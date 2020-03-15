CREATE TABLE `Sol` (
  `id` int NOT NULL,
  `mx` float NOT NULL,
  `mn` float NOT NULL,
  `av` float NOT NULL,
  `updatedAt` datetime NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `Sol`
--
ALTER TABLE `Sol`
  ADD PRIMARY KEY (`id`);
