#!/bin/bash

# define ---
render_line () {
	line='____________________________________________________________________________________________________'
	for elem in ${array[@]}; do
		line=$(echo $line | sed s/./1/$elem)
	done
	echo $line
}

move_digits_position () {
	for i in ${!array[@]}; do
		if [ "$((i % 2))" -eq "0" ]; then
			((array[$i]++))
		else
			((array[$i]--))
		fi
	done
}

start=19
stop=$((100-start))
step=2
counter=0

limit=32

# start ---
render_line
array=($(seq $start $step $stop))
while [ "$step" -le "$limit" ]; do

	render_line ${array[@]}

	if [ "$counter" -eq "$step" ]; then
		step=$((step*2))
		counter=1
	else
		((counter++))
		if [ "$counter" -eq "$limit" ]; then 
			break
		fi
	fi

	if [ "$counter" -le "$((step/2))" ]; then
		move_digits_position ${array[@]}
		
		# remove render array duplicates
		array=($(printf "%s\n" "${array[@]}" | sort -u | tr '\n' ' '))
	fi
done

