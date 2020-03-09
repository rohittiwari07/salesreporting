pipeline {
    agent any
    tools {
        maven 'Maven'
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
        stage('Dockerbuildapp') {
            steps {
                sh 'docker build -t sales_reporting .'
            }
        }
        stage('Dockerbuilddb') {
            steps {
                sh 'docker build -t db .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose down && docker-compose build --no-cache && docker-compose up'
            }
        }
    }
}