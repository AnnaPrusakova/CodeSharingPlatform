<html lang="en">
<head>
    <title>Latest</title>
    <style>pre{ border:groove; background-color:lightgrey; } span{ color:green;} </style>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#setting locale="en_US" >
    <#list lastCodes as lastCode>
        <div>
            <span id="load_date">${lastCode.formattedDate}</span>
            <pre id="code_snippet"><code>${lastCode.code}</code></pre>
        </div>
    </#list>
</body>
</html>