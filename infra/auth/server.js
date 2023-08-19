const express = require("express");
const app = express();
const mysql = require("mysql2/promise");

app.use(express.urlencoded());

app.post("/auth", async function (req, res) {
  const streamer = req.body.name;
  const streamkey = req.body.key;
  let dbStreamKey = "";

  try {
    var connection = await mysql.createConnection({
      host: "twitch-poc", // name of the db container
      port: "3306",
      user: "root",
      password: "root",
      database: "twitch-poc",
    });

    const [rows, fields] = await connection.execute(
      "SELECT streamKey as sk FROM `user_tbl` WHERE `name`= ?",
      [`${streamer}`]
    );

    dbStreamKey = rows[0].sk;

    if (dbStreamKey === streamkey) {
      console.log("connected!");
      res.status(200).send();
      return;
    }

    res.status(403).send();
  } catch (error) {
    console.log(error);
    res.status(403).send();
  }
});

app.listen(8000, function () {
  console.log("Listening on port 8000!");
});
