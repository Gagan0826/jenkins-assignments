pipeline {
                agent any
                stages {
                    stage('check for change in git') {
                        steps {
                            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Gagan0826/HTML-personal-site.git']])
                        }
                    }
                    stage('Git clone') {
                        steps {
                            sh('rm -rf jenkins-test-repo-1')
                            sh(' git clone https://Gagan_br_ITT@bitbucket.org/dvoptrain/jenkins-test-repo-1.git')
                            sh('ls')
                        }
                    }
                     stage('zip files') {
                        steps {
                            sh(' sudo apt update')
                            sh('sudo apt install zip -y')
                            sh('zip -r build-file.zip jenkins-test-repo-1')
                            sh('ls')
                        }
                    }
                    stage('ssh copy') {
                        steps {
	sshPublisher(publishers: [sshPublisherDesc(configName: 'slave-node-1', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'ls', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'build-file.zip')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                        }
                    }

            }
}
