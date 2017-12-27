/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

const By = require("selenium-webdriver").By;

// The starting URL
const url = "http://localhost:8080/todo";

class Todo {
    constructor(driver) {
        this.driver = driver;
        this.locators = {
            checkOffField: task => By.xpath(`//label[text() = "${task}"]`)
        }
    }

    open() {
        this.driver.get(url);
    }

    createTask(task) {
        const newTaskInput = this.driver.findElement(By.name("description"));
        newTaskInput.sendKeys(task);
        newTaskInput.submit();
    }

    checkOffTask(task) {
        this.driver.findElement(this.locators.checkOffField(task)).click();
    }
}

module.exports = Todo;