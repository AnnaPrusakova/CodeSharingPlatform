<html lang="en">
<head>
    <title>Create</title>
</head>

<body>
<pre>
    <code>
<form>
    <script>
        function send() {
            let object = {
                "code": document.getElementById("code_snippet").value
            };
            let json = JSON.stringify(object);
            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/code/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);
            if (xhr.status == 200) {
                alert("Success!");
            }
        }
    </script>

    <textarea id="code_snippet">...</textarea>
    <br>
    <h6>Time restriction:</h6> <input id="time-restriction" type="text"/>
    <br>
    <h6>Views restriction:</h6> <input id="views_restriction" type="text"/>
    <br>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
        </code>
</pre>
</body>
</html>