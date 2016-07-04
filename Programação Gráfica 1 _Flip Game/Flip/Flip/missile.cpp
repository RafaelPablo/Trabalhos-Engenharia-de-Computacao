#include "missile.h"
#include <QPainter>
#include <QTimer>
#include <QDebug>

Missile::Missile(QFrame *parent,const QColor color,int x, int y)
{

    this->_x = x;
    this->_y = y;
    this->_w_sz = 10;
    this->_h_sz = 10;
    this->_color = _color;

}

void Missile::draw(QPainter &p)
{
    p.setPen(_color);
    p.setBrush(Qt::red);
    p.drawRect(_x,_y,_w_sz,_h_sz);
    //p.drawRect(300,300,20,20);
    qDebug()<< "draw do missel" ;
    move();
    //QTimer::singleShot(10, this, SLOT(move()));

    //    QTimer *timer_bullet = new QTimer();
    //    QObject::connect(timer_bullet,SIGNAL(timeout()),this,SLOT(move()));
    //    timer_bullet->start(1000);


}

void Missile::setX(int x)
{
    this->_x = x;
}
void Missile::setY(int y)
{
    this->_y = y;
}
int Missile::getX()
{
    return _x;
}
int Missile::getY()
{
    return _y;
}

void Missile::setDirection(char d)
{
    this->_direction = d;
}

char Missile::getDirection()
{
    return this->_direction;
}

void Missile::set_h_sz(int h)
{
    this->_h_sz = h;
}
void Missile::set_w_sz(int w)
{
    this->_w_sz = w;
}

int Missile::get_h_sz()
{
    return this->_h_sz;
}
int Missile::get_w_sz()
{
    return this->_w_sz;
}


void Missile::move()
{
    if(_direction == 'u'){
        _y -=1;
    }
    if(_direction == 'd'){
        _y +=1;
    }
    if(_direction == 'r'){
        _x +=1;
    }
    if(_direction == 'l'){
        _x -=1;
    }
    qDebug()<<"move";
    QTimer::singleShot(10, this, SLOT(move()));
}
