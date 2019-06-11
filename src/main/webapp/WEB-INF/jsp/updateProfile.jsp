<%@page import="com.exchange.isep.model.ProfileUpdateInfo"%>
<%@page import="com.exchange.isep.model.UserDao"%>
<%@page import="com.exchange.isep.model.ApartmentDao"%>
<jsp:useBean id="u" class="com.exchange.isep.model.ProfileUpdateInfo"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = UserDao.update(u.getUser());
int j = ApartmentDao.update(u.getApartment());
if(i == 0 && j == 0) {
	request.getSession().setAttribute("message", "Profile updated sucessfully");
} else {
	request.getSession().setAttribute("message", "Profile update failed");
}

response.sendRedirect("/smarthome/profile");
%>