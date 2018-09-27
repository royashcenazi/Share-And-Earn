package com.servlets.schedueledTasks;

import dataBase.MongoInteractor;

public class DailyMongoJob implements Runnable {
    @Override
    public void run() {
        MongoInteractor.getInstance().dailyDataBaseUpdate();
    }
}
