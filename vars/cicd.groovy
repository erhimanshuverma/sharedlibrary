def gitDownload(repo)
{
git "https://github.com/erhimanshuverma/${repo}.git"
}

def buildArtifact()
{
	 sh "mvn package"
}

def Deploy(pipe, ip, context)
{
 sh "scp /var/lib/jenkins/workspace/${pipe}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war"
}

def runSelenium(pipeline)
{
    sh "java -jar /var/lib/jenkins/workspace/${pipeline}/testing.jar"
}
