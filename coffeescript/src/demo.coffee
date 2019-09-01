class Demo
  constructor: () ->
    console.log 'hello from demo'

  init: () ->
    console.log 'init...'
    $.ajax(
      url: 'http://localhost:8080/api/hello-world'
      success: (data) ->
        jsonDataString = JSON.stringify data
        $('#data-area').text jsonDataString
      error: (error) ->
        console.log 'cry me a river %s', error
    )
    console.log 'after init...'


$('document').ready ->
  demo = new Demo()
  demo.init()
