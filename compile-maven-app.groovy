pipeline{
	agent any
	tools {
		maven "maven_354"
		jdk "Jdk_8"
	    }
	stages {
		stage('checkout and compile'){
			steps{
				git url: 'https://github.com/DeNReLoaDeD/simple-maven-project-with-tests.git'
				sh 'mvn clean install'
		     	}
		}
		stage('archive'){
			steps{
				junit '**/target/surefire-reports/TEST-*.xml'
                  		archiveArtifacts 'target/*.jar'
		     	}
		}
		
	}
	
}
