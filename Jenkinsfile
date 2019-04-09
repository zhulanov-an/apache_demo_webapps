pipeline{
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('build'){
            steps{
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Archiving artifact ...'
                    archiveArtifacts "**/target/*.war"
                }
            }
        }
        stage('deploy to test & checkstyle'){
            parallel{
                stage('checkstyle'){
                    steps{
                        bat 'mvn checkstyle:checkstyle'
                    }
                    post{
                        success{
                            echo 'Publishing checkstyle results'
                            checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
                        }
                    }
                }
                stage('deploy to test environment'){
                    steps{
                        bat "xcopy /s/y webapp\\target\\webapp.war D:\\apache-tomcat-test\\webapps"
                    }
                }
            }
        }

        stage('deploy to production environment'){
            steps{
                timeout(time: 2, unit: 'DAYS') {
                    input message: 'Deploy to production: ', submitter: 'admin'
                }
                bat "xcopy /s/y webapp\\target\\webapp.war D:\\apache-tomcat-prod\\webapps"
            }
        }
    }
}