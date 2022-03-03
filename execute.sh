#!/bin/bash

############################################################
# Help                                                     #
############################################################
Help()
{
   # Display Help
   echo "Search stream for a text."
   echo
   echo "Syntax: ./execute.sh 10 Lpfn 200 10"
   echo "parameters:"
   echo "0     Number of processors, default value = 10."
   echo "1     Text to search for, default value = 'Lpfn'"
   echo "2     String length of each line of the stream, default value = 200"
   echo "3     Timeout in seconds, default value = 60."
   echo
}

############################################################
############################################################
# Main program                                             #
############################################################
############################################################

# Get the options
while getopts ":h" option; do
   case $option in
      h) # display Help
         Help
         exit;;
   esac
done

java -cp target/search-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.leapfin.search.App $1 $2 $3 $4