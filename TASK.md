= Security Task

Today's task is to practice security.

1. Run Payara and create a `FileRealm` called `CDRealm`. Create user `admin` in groups `admin,user` and `user` in group `user`.
2. Create a simple web application.
3. Create a page `index.xhtml` - this will be public
4. Create a directory `protected` and inside `index.xhtml`. This whole directory will be available only to group `user`
5. Create a directory `admin` and inside `index.xhtml`. This whole directory will be available only to group `admin`
6. Secure the `protected` directory by `web.xml`.
7. Secure the `admin` directory by `web.xml`.
8. Verify none of the directories is accessible.
9. Create login page.
10. Verify `user` can access `protected` directory and `admin` can access all pages.
11. Create logout functionality (`Logout` link on the main page will be enough).
12. Do similar thing in JAX-RS -- endpoints available to all, `user` and `admin`.

= Hints

`WEB-INF/web.xml` security settings, pages restrictions:

    <security-constraint>
        <display-name>Secured pages</display-name>
        <web-resource-collection>
            <web-resource-name>secured</web-resource-name>
            <url-pattern>/DIRECTORY/*</url-pattern>
        </web-resource-collection>
        <auth-constraint>
            <role-name>ROLENAME</role-name>
        </auth-constraint>
    </security-constraint>

Role description (add list of all roles in the app)

    <security-role>
        <description>DESCRIPTION</description>
        <role-name>ROLENAME</role-name>
    </security-role>

Login config definition - method, realm name and login page file:

    <login-config>
        <auth-method>FORM</auth-method>
        <!-- Default works with file realm -->
        <realm-name>REALMNAME</realm-name>
        <form-login-config>
            <form-login-page>/login.xhtml</form-login-page>
            <form-error-page>/login.xhtml</form-error-page>
        </form-login-config>
    </login-config>

Login page

    <form id="loginForm" method="post" action="j_security_check">
        <input type="text" name="j_username" placeholder="jméno"/> <br />
        <input type="password" name="j_password" placeholder="•••••" /><br/>
        <input type="submit" value="Login" />
    </form>


Logout from Faces

    ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

HTTPS

    <security-constraint>
        <user-data-constraint>
            <transport-guarantee>CONFIDENTIAL</transport-guarantee>
        </user-data-constraint>
