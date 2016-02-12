<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div>
    <jsp:include page="./partials/header.jsp"/>
    Hello world! Jeyyy !!! transforme moi en quelquechose de beau PLS !
    <div>
        This is the video for a test to DB :
        <p>${video.id}</p>
        <p>${video.name}</p>
        <a href="${video.url}">${video.url}</a>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>