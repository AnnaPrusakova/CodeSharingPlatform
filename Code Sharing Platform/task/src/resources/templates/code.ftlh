<html lang="en">
<head>
    <title>Code</title>
    <style>pre {
            border: groove;
            background-color: lightgrey;
        }

        span {
            color: green;
        } </style>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>

<body>
        <#setting locale="en_US" >
        <span id="load_date">${code.formattedDate}</span>
        <p>
            <#if code.viewsLimit && (code.views >= 0)>
            <span>
                <span id="views_restriction">${code.views}</span> more views allowed
            </span>
            </#if>
        </p>
        <p>
            <#if (code.time > 0)>
            <span>
                The code will be available for <span id="time_restriction">${code.time}</span> seconds
            </span>
            </#if>
        </p>
        <pre id="code_snippet"><code>${code.code}</code></pre>
</body>

</html>