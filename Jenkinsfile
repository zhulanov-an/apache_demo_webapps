pipeline{
    agent any
    stages {
        stage('build'){
            steps{
                echo 'Compiling'
                echo 'Testing'
                echo 'Packaging'
            }
        }
        stage('archive'){
            steps{
                echo 'Archiving'
            }
        }
        stage('deploy'){
            steps{
                echo 'Deploying'
            }
        }
    }
}