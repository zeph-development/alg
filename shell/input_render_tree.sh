#!/bin/bash

# define ---
render_line () {
	line='____________________________________________________________________________________________________'
	arr=("$@")
	for elem in ${arr[@]}; do
		line=$(echo $line | sed s/./1/$elem)
	done
	echo $line
}

move_digits_position () {
	for j in ${!array[@]}; do
		if [ "$((j % 2))" -eq "0" ]; then
			((array[$j]++))
		else
			((array[$j]--))
		fi
	done
}

# start ---
read N

rows=63
columns=100
levels=(32 16 8 4 2)

mirror_idx=$((${#levels[@]} - N))
first_line_one_length=$(((${levels[mirror_idx]} - 1) * ${levels[N-1]}))

start=$(((columns - first_line_one_length) / 2))
step=${levels[N - 1]}
stop=$(((columns - first_line_one_length) / 2 + first_line_one_length))

array=($(seq $start $step $stop))
offset=$((levels[N - 1]))

counter=0
for ((i=1;i<=$rows;i++)); do
	if [ "$i" -ge "$offset" ]; then
		render_line ${array[@]}

		if [ "$counter" -eq "$step" ]; then
			step=$((step*2))
			counter=1
		else
			((counter++))
		fi

		if [ "$counter" -le "$((step/2))" ]; then
			move_digits_position ${array[@]}
		 	array=($(printf "%s\n" "${array[@]}" | sort -u | tr '\n' ' '))
		fi
	else
		render_line
	fi
done