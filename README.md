# Camunda
Camunda BPM: Send Email with a service task implemented by a java class


<b>Configurations:</b> <br/>
In the src folder, there is available the BPMN model(src\main\resources --> diagram.bpmn).
The java class can be found on (src\main\java\com\camunda\demoEmail\demoEmail --> SendEmail.java).

<b>Its imperative inside the java class to specify your account and your password.</b>

<b>For example: String myAccountEmail="someone@gmail.com";
			String password="123456";</b><br/>


The mail.jar file must be inserted on the maven project. In your maven project, create a folder "lib" and paste the .jar file.
Then refresh the project on eclipse and right click on the jar file, selecting build path. This will install the library javax.mail.


<br/><b>Java project:</b><br/>
A similar <b>Java project</b> can be found on folder java project. 
By setting a valid account email and its password and running the main class (you need to specify the email address of the recipient), an email is sent.

