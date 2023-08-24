@Library("greeting") _
pipeline{
    agent any
    stages{
        stage("Build"){
            steps{
                script{
                    functions.add(5,6)
                }
            }
        }
    }
}
