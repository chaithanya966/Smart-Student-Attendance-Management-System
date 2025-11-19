Smart Student Attendance - Eclipse Dynamic Web Project (Non-Maven)

This archive contains two ready-to-import Eclipse Dynamic Web Projects:
- smart-attendance-tomcat9  (uses javax.servlet.*)  -> for Tomcat 9 / Java EE
- smart-attendance-tomcat10 (uses jakarta.servlet.*) -> for Tomcat 10+ / Jakarta EE

Import into Eclipse:
1. In Eclipse: File -> Import -> General -> Existing Projects into Workspace
2. Select root directory: the folder for the project (e.g., smart-attendance-tomcat9)
3. Make sure your server runtime is configured:
   - For tomcat9 project, add Apache Tomcat v9 runtime.
   - For tomcat10 project, add Apache Tomcat v10 runtime.
4. Right-click project -> Run As -> Run on Server.

Notes:
- Edit WebContent/WEB-INF/config.properties to set your DB URL, user, password.
- Run the SQL script at db/schema.sql to create the DB and sample data.
- Default admin credentials: admin / admin123

Git commands to push to a new GitHub repo (replace <your-repo-url>):
  git init
  git add .
  git commit -m "Initial commit - Smart Student Attendance (Eclipse Dynamic Web Project)"
  git branch -M main
  git remote add origin <your-repo-url>
  git push -u origin main
