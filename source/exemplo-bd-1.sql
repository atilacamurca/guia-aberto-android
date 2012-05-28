-- Distribuições Linux

CREATE TABLE distros (
   _id INTEGER PRIMARY KEY,
   nome TEXT NOT NULL,
   interface TEXT NOT NULL DEFAULT 'Gnome3',
   deriva_de INTEGER REFERENCES distros(_id)
);

INSERT INTO distros VALUES (1, 'Debian', 'Gnome3', NULL);
INSERT INTO distros VALUES (2, 'Ubuntu', 'Unity', 1);
INSERT INTO distros VALUES (3, 'Linux Mint', 'Mate', 2);
INSERT INTO distros VALUES (4, 'Fedora', 'KDE', NULL);
INSERT INTO distros VALUES (5, 'Slackware', 'KDE', NULL);
INSERT INTO distros VALUES (6, 'Slax', 'KDE', 5);
INSERT INTO distros VALUES (7, 'Ubuntu Studio', 'XFCE', 2);
INSERT INTO distros VALUES (8, 'kUbuntu', 'KDE', 2);
INSERT INTO distros VALUES (9, 'xUbuntu', 'XFCE', 2);
