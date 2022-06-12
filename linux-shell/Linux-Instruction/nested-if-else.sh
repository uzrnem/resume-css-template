echo "First arg: $1"
echo "Second arg: $2"

if [ "$1" == "run" ]; then
    echo "running"
else
    if [ "$2" == "something" ]; then
	    echo "Positional something"
	else
	    echo "sorry"
	fi
fi
