#!/usr/bin/perl

use 5.010;
use strict;
use warnings;


open(FH, '<', $filename) or die $!;


my $filename2 = 'c:\PerlPrograms\primeResult.txt';
open(DES, '>', $filename2) or die $!;
	
   print $_;
   if (index($_, "not") == -1) {
	my $index = index($_, ' ');
    	my $number = substr($_,0,$index);
	print DES "$number \n";
   }
   
}

close(des);