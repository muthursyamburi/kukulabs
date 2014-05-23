#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "dialog.h"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void on_actionTicket_Details_changed();

    void on_actionTicket_Details_triggered();

private:
    Ui::MainWindow *ui;
    Dialog *mDialog;
};

#endif // MAINWINDOW_H
