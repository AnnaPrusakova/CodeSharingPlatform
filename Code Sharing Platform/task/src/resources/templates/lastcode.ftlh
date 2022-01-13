<html lang="en">
<head>
    <title>Latest</title>
    <style>pre{ border:groove; background-color:lightgrey; } span{ color:green;} </style>
</head>
<body>
<#setting locale="en_US" >
    <#list lastCodes as lastCode>
        <div>
            <span id="load_date">${lastCode.date}</span>
            <pre id="code_snippet">${lastCode.code}</pre>
        </div>
    </#list>
</body>
</html>