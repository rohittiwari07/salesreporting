pipeline {
    agent any
    tools {
        maven 'Maven',
        docker 'Docker'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh ''' 
                    echo "$PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                   '''
            }
        }
        stage ('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Dockerbuild') {
            steps {
                sh 'docker build -t sales_reporting .'
            }
        }
    }
}