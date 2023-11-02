import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JEditorPane;
import org.sms.service.api.SMS;
/**
*
* @author ADMIN
*/
public class purchase2 extends HttpServlet {

/**
* Processes requests for both HTTP
* <code>GET</code> and
* <code>POST</code> methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
try { HttpSession so = request.getSession(true);

String url = "jdbc:mysql://localhost:3306/purchase";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url, "root", "root");
PreparedStatement ps;
int pid=1000,pid1=0,pid2=0,pid3=0; String as="";
Statement st1 = con.createStatement();
Statement st2 = con.createStatement();
Statement st = con.createStatement();
String s1=request.getParameter("s1");
String s2 = request.getParameter("s2");
String a1= request.getParameter("a1");
String a2 = request.getParameter("a2");
String a3 = request.getParameter("a3");
String a4 = request.getParameter("a4");
String a5 = request.getParameter("a5");
String a6 = "400";
String a7 = request.getParameter("a7");
String a11 = request.getParameter("a8");
String a9 = request.getParameter("a9");
String a10 = request.getParameter("a10");
String h1="",h2="",h3="",h4="",h5="";
int t1=0,t2=0,t3=0,t4=0,t5=0;
int t11=0,t12=0,t13=0,t14=0,t15=0; SMS sc=new SMS();
String a8=""; String p1="",p2="",p3="",p4="",p5="",p6="";
java.util.Date st11 = new java.util.Date();
// Formatting date into yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10
int f1=0,f2=0;
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String f = formatter.format(st11);
System.out.println("Formatted date is ==>" + f);
int randomInt = 0;
Random randomGenerator = new Random();
for (int idx = 1; idx <= 10; ++idx) {
randomInt = randomGenerator.nextInt(100000);

}
if((s1!=null) )
{
if((a1!=null)|| (a2!=null)|| (a3!=null) || (a4!=null) || (a5!=null)|| (a6!=null) )
{
t1=Integer.parseInt(a5);
t2=Integer.parseInt(a7);
t3=(t1*t2);
a8 =t3+"";





System.out.println(a1+a2+a3+a4+a5+a6+a7+a8);



request.setAttribute("ok", "1");
request.setAttribute("a1", a1);
request.setAttribute("a2", a2);
request.setAttribute("a3", a3);
request.setAttribute("a4", a4);
request.setAttribute("a5", a5);
request.setAttribute("a6", a6);
request.setAttribute("a7", a7);
request.setAttribute("a8", a8);

// request.setAttribute("msg", "Account Registered Successfully");
RequestDispatcher requestdispatcher = request.getRequestDispatcher("upurchases.jsp");
requestdispatcher.forward(request, response);










}else {
request.setAttribute("ok", "1");
request.setAttribute("msg", "Please Enter all the Values");
RequestDispatcher requestdispatcher = request.getRequestDispatcher("upurchases.jsp");
requestdispatcher.forward(request, response);
}


}else if(request.getParameter("s3")!=null){

String as1="";
ResultSet rs6 = (ResultSet) st1.executeQuery("select * from product where pid='"+a1+"'");
if(rs6.next()){
t11=Integer.parseInt(rs6.getString(7));
f1=Integer.parseInt(rs6.getString(13));
p1=rs6.getString(8);
p2=rs6.getString(9);
p3=rs6.getString(11);
p4=rs6.getString(5); p5=rs6.getString(12);
p6=rs6.getString(9);
as1=rs6.getString(2);
System.out.println(t11);
as=rs6.getString(8);
}

if(p6.equalsIgnoreCase("admin")){
if(a10.length()>=16){
System.out.println(a9);
int h=1;
System.out.println(a9);
if(h==1){
ResultSet rs12 = (ResultSet) st.executeQuery("select * from register where username='" + so.getAttribute("un")+ "'");
if(rs12.next()){
ResultSet rs3 = (ResultSet) st1.executeQuery("select max(pid) from purchase");
if(rs3.next()){
pid1=Integer.parseInt(rs3.getString(1));
pid=pid1+1;
}


System.out.println(a1+a2+a3+a4+a5+a6+t2+t3);

System.out.println("insert into purchase values('"+pid+"','"+rs12.getString(3) +"','"+rs12.getString(8) +"','"+rs12.getString(7) +"','"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+t3+"','"+f+"')");
int v=st2.executeUpdate("insert into purchase values('"+pid+"','"+rs12.getString(3) +"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a7+"','"+a11+"','"+f+"','"+p1+"','"+p2+"','"+p3+"','"+a1+"','"+p4+"','"+p5+"')");

System.out.println("update product set stock='"+t13+"' where pid='"+a1+"' ");
int v1=st2.executeUpdate("update product set pcount='"+f1+"' where pid='"+a1+"' ");

if((v==1)&&(v1==1)) {


request.setAttribute("ok", "1");

request.setAttribute("a1", a6);

request.setAttribute("a7", a7);

request.setAttribute("msg", "Product Purchased Successfully");
request.setAttribute("a11", "product1\\"+a1+"."+as1);
RequestDispatcher requestdispatcher = request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request, response);
}else{


request.setAttribute("ok", "1");

request.setAttribute("msg", "Password didnot match");

RequestDispatcher requestdispatcher =request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request, response);
}






}
}else{
request.setAttribute("ok", "1");

request.setAttribute("msg", "Password didnot match");

RequestDispatcher
requestdispatcher =
request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request,
response);
}

}else{
request.setAttribute("ok", "1");

request.setAttribute("msg", "Please enter creditcard Correctly");

RequestDispatcher
requestdispatcher =
request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request,
response);
}
}else{
if(a10.length()>=16){
System.out.println(a9);
int h=1;
System.out.println(a9);
if(h==1){
ResultSet rs12 = (ResultSet) st.executeQuery("select * from register where username='" + so.getAttribute("un")+ "'");
if(rs12.next()){
ResultSet rs3 = (ResultSet) st1.executeQuery("select max(pid) from purchase");
if(rs3.next()){
pid1=Integer.parseInt(rs3.getString(1));
pid=pid1+1;
}
ResultSet rs4 = (ResultSet) st1.executeQuery("select amt from dealer where username='"+p6+"'");
if(rs4.next()){
pid2=Integer.parseInt(rs4.getString(1));

} ResultSet rs14 = (ResultSet) st1.executeQuery("select amt from admin where name='admin'");
if(rs14.next()){
pid3=Integer.parseInt(rs14.getString(1));

}
t12=Integer.parseInt(a7);
System.out.println(t12);
t13=t11-t12;
t14=((t12*90)/100)+pid2;
t15=((t12*10)/100)+pid3;
f1=f1+t12;
if(t11>t12){
System.out.println(a1+a2+a3+a4+a5+a6+t2+t3);
sc.SendSMS(rs12.getString(10),"Product Id"+a1+a2+a3+a4+a5+a6);
mail(rs12.getString(6), "Product Id"+a1+a2+a3+a4+a5+a6);
System.out.println("insert into purchase values('"+pid+"','"+rs12.getString(3) +"','"+rs12.getString(8) +"','"+rs12.getString(7) +"','"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+t3+"','"+f+"')");
int v=st2.executeUpdate("insert into purchase values('"+pid+"','"+rs12.getString(3) +"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a7+"','"+a11+"','"+f+"','"+p1+"','"+p2+"','"+p3+"','"+a1+"','"+p4+"','"+p5+"')");

System.out.println("update product set stock='"+t13+"' where pid='"+a1+"' ");
int v1=st2.executeUpdate("update product set stock='"+t13+"', pcount='"+f1+"' where pid='"+a1+"' ");
int v2=st2.executeUpdate("update dealer set amt='"+t14+"' where username='"+p6+"'");
int v3=st2.executeUpdate("update admin set amt='"+t15+"' where name='admin'");
System.out.println("update admin set amt='"+t15+"' where name='admin'");
System.out.println("update dealer set amt='"+t14+"' where username='"+p6+"'");
if((v==1)&&(v1==1)&&(v2==1)&&(v3==1)) {


request.setAttribute("ok", "1");

request.setAttribute("a1", a6);

request.setAttribute("a7", a7);

request.setAttribute("msg", "Account Registered Successfully");

RequestDispatcher requestdispatcher = request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request, response);
}else{


request.setAttribute("ok", "1");

request.setAttribute("msg", "Password didnot match");

RequestDispatcher requestdispatcher =request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request, response);
}
}else{

request.setAttribute("ok", "1");

request.setAttribute("msg", "Please Enter the product upto stock");

RequestDispatcher requestdispatcher =request.getRequestDispatcher("upurchases.jsp");

requestdispatcher.forward(request, response);
}





}
}else{
request.setAttribute("ok", "1");

request.setAttribute("msg", "Password didnot match");

RequestDispatcher
requestdispatcher =
request.getRequestDispatcher("upurchase.jsp");

requestdispatcher.forward(request,
response);
}

}else{
request.setAttribute("ok", "1");

request.setAttribute("msg", "Please enter creditcard Correctly");

RequestDispatcher
requestdispatcher =
request.getRequestDispatcher("upurchase.jsp");

requestdispatcher.forward(request,
response);
}
}

}
else {
request.setAttribute("ok", "1");
request.setAttribute("msg", "Please Enter all the Values");
RequestDispatcher requestdispatcher = request.getRequestDispatcher("upurchases.jsp");
requestdispatcher.forward(request, response);
}






}catch(Exception e) {
e.printStackTrace();
} finally {
out.close();
}
}
public void mail(String sa,String sa1){
final String username = "asvperumal@gmail.com";
final String password = "16/05/1986";

Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");

Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});

try {
System.out.println(sa+" "+sa1);
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("asvperumal@gmail.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(sa));
message.setSubject("Testing Subject");
message.setText("Dear Mail Crawler,"+sa1
+ "\n\n No spam to my email, please!");

Transport.send(message);

System.out.println("Done");

} catch (MessagingException e) {
throw new RuntimeException(e);
}
}
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
* Handles the HTTP
* <code>GET</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Handles the HTTP
* <code>POST</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>
}