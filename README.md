osb-export
==========

Maven plugin to export oracle service bus configuration without oepe and weblogic.

build project:
mvn clean package


Oracle servis bus configuration is set of resources. This maven plugin will pack resources into jar file. File could be used to import configuration into Oracle service bus.

==========
osb configuration export.

create pom.xml in your configuration directory. (all project must be in one directory) with this 

<project xmlns ...
  ...
  <packaging>osb-conf</packaging>
  ...
  
  <build>
    <plugins>
      ...
      <plugin>
        <groupId>org.mates.osb</groupId>
  	    <artifactId>osbexport-project</artifactId>
  	    <version>0.0.1-SNAPSHOT</version>
        <extensions>true</extensions>
        <configuration>        
          <ignoredDirs>
            <param>test</param>
            <param>docs</param>
          </ignoredDirs>
        </configuration>
      </plugin>
      ...
    <plugins>
  <build>
  
  ...
</project>


then you can call 

mvn clean package

and in target directory is output.
==========
