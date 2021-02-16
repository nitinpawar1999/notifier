<style>
    .reg-success-page {
        width: 360px;
        padding: 10px;
        margin: auto;
        background-color: whitesmoke;
    }

    body {
        background: #76b852;
        /* fallback for old browsers */
        background: -webkit-linear-gradient(right, #76b852, #8DC26F);
        background: -moz-linear-gradient(right, #76b852, #8DC26F);
        background: -o-linear-gradient(right, #76b852, #8DC26F);
        background: linear-gradient(to left, #76b852, #8DC26F);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>

<head>
    <meta http-equiv="refresh" content="3; URL=<%=request.getContextPath()%>" />
</head>

<body>
    <div class="reg-success-page">
        <h3>Registration Successful</h3>
        <h3>Redirecting to login-page</h3>
        <p>If you are not redirected in three seconds, <a href="<%=request.getContextPath()%>">click here</a>.</p>
    </div>
</body>