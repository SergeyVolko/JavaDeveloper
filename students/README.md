# Домашнее задание №15. Постановка задачи.

Реализовать учет успеваемости студентов по предметам. 

У каждой сдачи есть имя, фамилия, предмет и оценка.

## Требования
- Реализовать интерфейс у которого есть методы
  - добавить сдачу студента (в зачет идет только последняя сдача, хранить все сдачи студента по одному и тому же предмету не нужно)
  - получить сдачу студента по имени и фамилии и предмету
  - вывод средней оценки по предмету
  - вывод студентов кто сдавал более одного раза
  - вывод последних пяти студентов сдавших на отлично по любому предмету
  - вывод всех сданных предметов
- Сделать кеш для вывода средней оценки по предмету за пределами интерфейса `Examination`

## Решение

Скриншот сборки проекта.
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/students/%D0%94%D0%97%E2%84%9615.png?raw=true)<br><br>
Вывод сборки в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe -Dmaven.multiModuleProjectDirectory=C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students -Djansi.passthrough=true "-Dmaven.home=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3" "-Dclassworlds.conf=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\bin\m2.conf" "-Dmaven.ext.class.path=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven-event-listener.jar" "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50115:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\boot\plexus-classworlds-2.7.0.jar;C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\boot\plexus-classworlds.license" org.codehaus.classworlds.Launcher -Didea.version=2024.1 install
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< org.example:students >------------------------
[INFO] Building students 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ students ---
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ students ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 7 source files with javac [debug target 17] to target\classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ students ---
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\src\test\resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ students ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 2 source files with javac [debug target 17] to target\test-classes
[INFO] 
[INFO] --- surefire:3.2.2:test (default-test) @ students ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom (4.5 kB at 3.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom (2.5 kB at 14 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom (2.7 kB at 15 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar (27 kB at 43 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar (18 kB at 31 kB/s)
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.students.ExaminationTest
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.320 s -- in org.example.students.ExaminationTest
[INFO] Running org.example.students.TestAverageCache
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s -- in org.example.students.TestAverageCache
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ students ---
[INFO] Building jar: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\target\students-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.1:install (default-install) @ students ---
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\pom.xml to C:\Users\Lenovo\.m2\repository\org\example\students\1.0-SNAPSHOT\students-1.0-SNAPSHOT.pom
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\target\students-1.0-SNAPSHOT.jar to C:\Users\Lenovo\.m2\repository\org\example\students\1.0-SNAPSHOT\students-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  23.257 s
[INFO] Finished at: 2024-11-28T09:40:41+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
```

