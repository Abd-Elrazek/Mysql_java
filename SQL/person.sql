-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2019 at 09:24 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `person`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `age`) VALUES
(1, 'abdelrazek', 'Mahmoud', 27),
(4, 'abdelrazek', 'nasser', 42),
(6, 'abdelrazek', 'nageh', 23),
(8, 'abdelrazek', 'nageh', 23),
(16, 'abdelrazek', 'nasser', 42),
(17, 'abdelrazek', 'nasser', 42),
(18, 'abdelrazek', 'nasser', 42),
(19, 'abdelrazek', 'nasser', 42),
(21, 'abdelrazek', 'nasser', 42),
(22, 'abdelrazek', 'nasser', 42),
(23, 'abdelrazek', 'nasser', 42),
(25, 'dfdf', 'nasser', 444),
(30, 'nassser', 'nasser', 42),
(33, 'abdelrazek', 'nasser', 42),
(38, 'abdelrazek', 'nasser', 42),
(39, 'dfdfdsfasdf', 'nasser', 42),
(40, 'abdelrazek', 'nasser', 42),
(41, 'abdelrazek', 'nasser', 42),
(42, 'abdelrazek', 'nasser', 42),
(45, '?????????', '???? ', 3),
(46, 'abdelrazek', 'nasser', 42),
(47, 'abdelrazek', 'nasser', 42),
(48, 'abdelrazek', 'Mahmoud', 27);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
