-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 29 avr. 2019 à 19:07
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `simple_faculte_produit`
--

--
-- Déchargement des données de la table `categorie_produit`
--

INSERT INTO `categorie_produit` (`id`, `libelle`, `reference_compte_buditaire`) VALUES
(59, 'pc', 'rcb-2'),
(64, 'stylo', 'rcb-2'),
(4, 'imprimante', 'rcb1'),
(66, 'bureau', 'rcb-3');

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(67),
(67),
(67);

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `reference`, `categorie_produit`, `type_produit`) VALUES
(8, 'azus-03', 'pr-4', 59, 62),
(45, 'hp-p', 'pr-1', 4, 7),
(46, 'pr-3', 'pr-3', 4, 6),
(54, 'hp-8', 'pr-6', 4, 6);

--
-- Déchargement des données de la table `type_produit`
--

INSERT INTO `type_produit` (`id`, `code`, `libelle`) VALUES
(6, '3.00', 'melange'),
(7, '1.00', 'detatil'),
(62, '2.00', 'jemlaa');
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
