import turtle
turtle.color("red")
turtle.bgcolor("blue")
for i in range(200):
    for j in range(200):
        turtle.forward(i)
        turtle.left(j+4)
turtle.exitonclick()