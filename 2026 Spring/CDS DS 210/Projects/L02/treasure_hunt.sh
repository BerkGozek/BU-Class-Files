#!/usr/bin/env bash

base="treasure_hunt"
dir="$base"
i=0

while [ -d "$dir" ]; do
  dir="${base}_$i"
  ((i++))
done

mkdir "$dir" && cd "$dir" || exit 1

read -p "Enter your name: " name

{
echo "name: $name\n" 
echo "whoami: $(whoami)\n" 
echo "hostname: $(hostname)\n" 
echo "pwd: $(pwd)\n" 
echo "\$HOME: $HOME\n" 
} >> command_line_scavenger_hunt.txt

echo "The treasure is hidden in plain sight" > clue_1.txt

mkdir secret_chamber && cd secret_chamber

echo "Look for a hidden file" > clue_2.txt

echo "Congratulations. You found the treasure" > .treasure_map.txt

cd .. && cd ..

zip -r "$dir".zip "$dir"