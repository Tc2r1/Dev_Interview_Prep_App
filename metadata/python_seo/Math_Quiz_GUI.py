import tkinter
from tkinter import *
import random


questions =[
            '""a"+"bc""',
           '"abcd"[2:]',
           '>>>print (r"/nhello")',
           "This is sample question 4 ?",
           "This is sample question 5 ?",
           "This is sample question 6 ?",
           "This is sample question 7 ?",
            "This is sample question 8 ?",
            "This is sample question 9 ?",
           "This is sample question 10?",
           ]

answer_choise = [
                ["a","bc","bca","abc",],
                ["a","ab","cd","dc",],
                ["a new line and hello","/nhello","the letter r and then hello","error",],
                ["1","D","3","4",],
                ["1","D","3","4",],
                ["1","2","3","D",],
                ["1","D","3","4",],
                ["D","2","3","4",],
                ["1","D","3","4",],
                ["1","2","D","4",],
                ]
answers=[1,1,1,1,1,3,1,0,1,3]
user_answer=[]
indexes=[]
def gen():
    global indexes
    while(len(indexes)<5):
        x=random.randint(0,9)
        indexes.append(x)
        if x in indexes:
            continue
        else:
            indexes.append(x)

def showresult(score):
    label4text.destroy()
    label3text.destroy()
    lblQuestion.destroy()
    r1.destroy()
    r2.destroy()
    r3.destroy()
    r4.destroy()

    labelimage=Label(root,border=0,background="#ffffff")
    labelimage.pack(pady=(50,10))

    labelresulttext=Label(root,font=("arial",20),background="#ffffff")
    labelresulttext.pack(pady=(50,10))
    labelscore=Label(root,font=("arial",20))
    labelresulttext.pack()


    if score >=20:
        img=PhotoImage(file="win.png")
        labelimage.configure(image=img)
        labelimage.image = img
        labelresulttext.configure(text="You are Perfect !")


    elif score<20 and score>=10 :
        img = PhotoImage(file="win.png")
        labelimage.configure(image=img)
        labelimage.image = img
        labelresulttext.configure(text="You are not BAD !")

    else:
        img = PhotoImage(file="lose.png")
        labelimage.configure(image=img)
        labelimage.image=img
        labelresulttext.configure(text="You are so BAD !")



def calc():
    global indexes,user_answer,answers
    x=0
    global score
    score=0
    for i in indexes:
        if user_answer[x]==answers[i]:
            score=score+5
            x+=1
    print(score)
    showresult(score)


ques=1
def selected():
    global radiovar,user_answer
    global lblQuestion,r1,r2,r3,r4
    global ques
    x = radiovar.get()
    user_answer.append(x)
    if ques<5:
        lblQuestion.config(text=questions[indexes[ques]])
        r1["text"]=answer_choise[indexes[ques]][0]
        r2["text"]=answer_choise[indexes[ques]][1]
        r3["text"]=answer_choise[indexes[ques]][2]
        r4["text"]=answer_choise[indexes[ques]][3]
        ques +=1
    else:
        print(indexes)
        print(user_answer)
        print(student_id.get())
        calc()


def startQuiz():
    global lblQuestion,r1,r2,r3,r4
    #Wraplength 400 sonrasına yazma aşağıya yaz der !<3
    lblQuestion=Label(root,text=questions[indexes[0]],font=("arial",15,"bold"),width=500,justify="center",wraplength=400)
    lblQuestion.pack(pady=(100,30))
    global radiovar
    radiovar=IntVar()
    radiovar.set(-1)
    r1=Radiobutton(root,text=answer_choise[indexes[0]][0],
                   font=("arial",12),value=0,variable=radiovar,
                   command=selected,background="#ffffff")
    r1.pack()
    r2 = Radiobutton(root, text=answer_choise[indexes[0]][1],
                     font=("arial", 12), value=1, variable=radiovar,command=selected,background="#ffffff")
    r2.pack()
    r3= Radiobutton(root, text=answer_choise[indexes[0]][2],
                     font=("arial", 12), value=2, variable=radiovar,command=selected,background="#ffffff")
    r3.pack()
    r4 = Radiobutton(root, text=answer_choise[indexes[0]][3],
                     font=("arial", 12), value=3, variable=radiovar,command=selected,background="#ffffff")
    r4.pack()



def startIsPressed():
    global label4text
    global label3text
    label4text = Label(root, text="Name:"+name.get(), font=("arial", 10,"bold"), background="#000000",foreground="#FACA2F")
    label4text.place(x=0, y=0)
    label3text = Label(root, text="Student ID:" + student_id.get(), font=("arial", 10, "bold"), background="#000000",foreground="#FACA2F")
    label3text.place(x=180, y=0)

    labelimg.destroy()
    labeltext.destroy()
    labeltext2.destroy()
    lblInstruction.destroy()
    btnStart.destroy()
    lblRules.destroy()
    entry1.destroy()
    entry2.destroy()
    gen()
    startQuiz()




root=Tk()
root.title("Quiz")
root.geometry("700x600")
root.config(background="#ffffff")
root.resizable(0,0)


img1=PhotoImage(file="rsz_quizz.png")

labelimg=Label(root,image=img1,background="#ffffff")
labelimg.pack(pady=(40,0))

name=StringVar()
student_id=StringVar()




labeltext=Label(root,text="Full Name ",font=("arial",13,"bold"),background="#ffffff")
labeltext.place(x=220,y=180)
entry1=Entry(root,textvariable=name,font=("arial",10),width=15,bg="SteelBlue1")
entry1.place(x=210,y=230)

labeltext2=Label(root,text="Student ID",font=("arial",13,"bold"),background="#ffffff")
labeltext2.place(x=390,y=180)
entry2=Entry(root,textvariable=student_id,font=("arial",10),width=15,bg="SteelBlue1")
entry2.place(x=380,y=230)

img2=PhotoImage(file="start.png")

btnStart=Button(root,image=img2,relief=FLAT,border=0,background="#ffffff",command=startIsPressed)
btnStart.pack(pady=(100,0))




lblInstruction=Label(root,text="Read The Rules Below and\n Click Start When You Ready",background="#ffffff",font=("Concolas",14),justify="center")
lblInstruction.pack(pady=(15,70))

lblRules=Label(root,text="Each team will be asked 2 questions of 10 marks each.\n They will be given 30 seconds for each question."
                         ,width=100,font=("Times",14),background="#000000",foreground="#FACA2F")
lblRules.pack()





root.mainloop()