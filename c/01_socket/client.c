/****
* network socket in linux 20200507
*	source: https://www.cs.rpi.edu/~moorthy/Courses/os98/Pgms/socket.html
*/

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <unistd.h>
#include <netdb.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

// error function
void error (char *msg) {
    perror(msg);
    exit(0);
}

// main, start point
int main(int argc, char *argv[]) {
    int sockfd, portno, n;

    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[256];
    if (argc < 3) {
        fprintf(stderr, "usage %s hostname port\n", argv[0]);
        exit(0);
    }

	// setup client socket
    portno = atoi(argv[2]);
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd <0 ) error("ERROR opening socket");

	//initialize server settings
    server = gethostbyname(argv[1]);
    if (server == NULL) {
        fprintf(stderr, "ERROR, no such host");
        exit(0);
    }

    bzero((char *)&serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *) server->h_addr,
            (char *) &serv_addr.sin_addr.s_addr,
            server->h_length);
    serv_addr.sin_port = htons(portno);
	
	// connect to server
    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) <0 )
        error("ERROR connecting");
    
    printf("Please enter the message: ");
    bzero(buffer, 256);
    fgets(buffer, 255, stdin);

	// write to server
    n = write(sockfd, buffer, strlen(buffer));
    if ( n < 0 ) error("ERROR writing to socket");
	// read from server
    bzero(buffer, 256);
    n = read(sockfd, buffer, 255);
    if ( n < 0 ) error("ERROR reading from socket");
    printf("%s\n", buffer);
    return 0;

}
