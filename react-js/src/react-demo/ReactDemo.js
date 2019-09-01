import React, { Component } from 'react'
class ReactDemo extends Component {

    state = {
        data: []
    };

    componentDidMount() {
        fetch('http://localhost:8080/api/hello-world')
            .then(res => res.json())
            .then((data) => {
                this.setState({data: data});
            })
            .catch(console.log)
    }

    render() {
        return (
            <div className="demo">
                <h1>React Demo (React is not a transpiler)</h1>
                <h2>Loading data</h2>
                <pre>{ JSON.stringify(this.state.data) }</pre>
            </div>
        );
    }
}

export default ReactDemo
