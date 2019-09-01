package at.fhcampus.we.gwtdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.RootPanel;

public class GWTDemo implements EntryPoint {

    @Override
    public void onModuleLoad() {
        // Build request
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "http://localhost:8080/api/hello-world");
        try {
            // Send request
            builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        // Everything went A-OK
                        GWT.log(response.getText());
                        RootPanel.get("loading-area").getElement().setInnerText(response.getText());
                    } else {
                        // Problem
                        displayError("Couldn't retrieve JSON (" + response.getStatusText() + ")");
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    displayError("Couldn't retrieve JSON");
                }
            });
        } catch (RequestException e) {
            GWT.log("Couldn't retrieve JSON", e);
        }
    }

    private void displayError(String s) {
        GWT.log(s);
    }
}
