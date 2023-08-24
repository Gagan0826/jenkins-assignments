@Library("greeting") _

pipeline {
    agent {
        label "node-1"
    }
    stages {
        stage("clear workspace") {
            steps {
                cleanWs()
            }
        }
        stage("using shared library") {
            steps {
                script {
                    functions.add(5, 6)
                }
            }
        }
        stage("Install Apache2") {
            steps {
                sh 'sudo apt update' 
                sh 'sudo apt install apache2 -y'
            }
        }
        
        stage("unzip") {
            steps {
                sh('sudo apt install unzip')
                sh('pwd')
                sh('unzip /home/ubuntu/build-file.zip -d .')
                sh('ls')
                
            }
        }
        stage("Copy and Host to Apache2") {
            steps {
                sh 'ls'
                sh 'sudo cp -r jenkins-test-repo-1/HTML-personal-site-master/* /var/www/html'
            }
        }
    }
    post {
        success {
            emailext body: 'the build is successful', subject: 'success message', to: 'gaganbrgirish16@gmail.com'
            emailext body: 'the build is successful', subject: 'success message', to: 'saumya.sharma@intimetec.com'
        }
        failure {
            emailext body: 'the build is failed', subject: 'failure message', to: 'gaganbrgirish16@gmail.com'
            emailext body: 'the build is failed', subject: 'failure message', to: 'saumya.sharma@intimetec.com'
        }
    }

}
