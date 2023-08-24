@Library("greeting") _
pipeline {
    agent any

    stages {
        stage('check for chage in git') {
            steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Gagan0826/HTML-personal-site.git']])
            }
            
        }
        stage('build a job') {
            steps {
               build 'build-job'
            }
            
        }
    }
}
