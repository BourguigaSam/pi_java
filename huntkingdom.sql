-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 juin 2020 à 22:54
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `huntkingdom`
--

-- --------------------------------------------------------

--
-- Structure de la table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `repliesnumber` bigint(20) DEFAULT NULL,
  `likesnumber` bigint(20) DEFAULT NULL,
  `dateCreation` datetime DEFAULT current_timestamp(),
  `Idauthor` int(11) DEFAULT NULL,
  `categorie` int(11) DEFAULT NULL,
  `accept` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `blog`
--

INSERT INTO `blog` (`id`, `title`, `content`, `image`, `repliesnumber`, `likesnumber`, `dateCreation`, `Idauthor`, `categorie`, `accept`) VALUES
(34, 'taz', 'taz', '8NQBX6QY4N.jpg', NULL, NULL, '2020-06-01 10:09:23', NULL, NULL, NULL),
(35, 'zaaa', 'zaa', '8NQBX6QY4N.jpg', NULL, NULL, '2020-06-01 10:11:59', NULL, NULL, NULL),
(37, '0', '0', '8NQBX6QY4N.jpg', NULL, NULL, '2020-06-01 10:20:35', NULL, NULL, NULL),
(38, 'yes', 'yes', 'BT4AO830EJ.jpg', NULL, NULL, '2020-06-01 10:58:25', NULL, NULL, NULL),
(39, 'za', 'za', 'ZQRTM47VF1.jpg', NULL, NULL, '2020-06-01 11:32:01', NULL, NULL, NULL),
(40, 'testpi', 'testpi', '30IR9IHE0S.jpg', NULL, NULL, '2020-06-01 12:43:28', NULL, NULL, NULL),
(41, 'new blog', 'Hello this new Blog ', 'JPP4QFOV1D.jpg', NULL, NULL, '2020-06-01 14:33:52', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `blog2`
--

CREATE TABLE `blog2` (
  `id` int(11) NOT NULL,
  `categorie` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `repliesnumber` bigint(20) DEFAULT NULL,
  `likesnumber` bigint(20) DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  `Idauthor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `blog_like`
--

CREATE TABLE `blog_like` (
  `id` int(11) NOT NULL,
  `user` int(11) DEFAULT NULL,
  `blog` int(11) DEFAULT NULL,
  `comment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `blog_like`
--

INSERT INTO `blog_like` (`id`, `user`, `blog`, `comment`) VALUES
(24, 1, 7, NULL),
(28, 1, 12, NULL),
(30, 1, 26, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Fishing'),
(2, 'Huntking'),
(10, 'aaa'),
(11, 'tazz'),
(12, 'tazz'),
(13, 'efzfezfez'),
(14, 'Fishing'),
(15, 'Huntking');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_blog`
--

CREATE TABLE `categorie_blog` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `category`) VALUES
(5, 'Fishing'),
(6, 'Hunting');

-- --------------------------------------------------------

--
-- Structure de la table `catgory_car`
--

CREATE TABLE `catgory_car` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `user` int(11) DEFAULT NULL,
  `blog` int(11) DEFAULT NULL,
  `publishdate` datetime NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `user`, `blog`, `publishdate`, `content`) VALUES
(28, 1, 21, '2020-02-24 15:19:27', '***'),
(29, 1, 21, '2020-02-24 15:19:35', '***'),
(30, 1, 21, '2020-02-24 15:19:40', '***'),
(31, 1, 21, '2020-02-24 15:19:47', 'nacef'),
(32, 1, 12, '2020-02-25 15:00:30', '***'),
(33, 1, 12, '2020-02-25 15:00:43', '***'),
(34, 1, 7, '2020-02-27 01:15:00', 'qsccqs'),
(35, 1, 26, '2020-02-28 11:35:15', '***');

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `name`, `email`, `phone`, `subject`, `message`, `user`) VALUES
(1, 'moetaz brayek', 'moetazbusiness@gmail.com', 28852858, 'hi', 'hi bad service', 1),
(93, 'moetaz brayek', 'moetazbusiness@gmail.com', 28852858, 'hi', 'bad', 1),
(94, 'ezfze', 'fez@zefze', 28852858, 'hello', 'very good service', 1),
(95, 'ezfze', 'fez@zefze', 28852858, 'hello', 'not good service', 1),
(96, 'ezfze', 'fez@zefze', 28852858, 'hello', 'normal', 1),
(97, 'ezfze', 'fez@zefze', 28852858, 'hello', 'Test', 1);

-- --------------------------------------------------------

--
-- Structure de la table `contract`
--

CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `location` int(11) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `barcode` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date_debut_location` datetime NOT NULL,
  `date_fin_location` datetime NOT NULL,
  `date` datetime NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `acceptcontract` tinyint(1) NOT NULL,
  `phonenumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `contract`
--

INSERT INTO `contract` (`id`, `location`, `owner`, `barcode`, `date_debut_location`, `date_fin_location`, `date`, `type`, `acceptcontract`, `phonenumber`) VALUES
(15, 1, 1, 'g5zmbdiyst', '2015-01-01 00:00:00', '2015-01-01 00:00:00', '2020-02-28 10:20:25', 'Voiture', 1, 28873851),
(16, 1, 1, '2ybu1aro5g', '2015-01-01 00:00:00', '2015-03-01 00:00:00', '2020-02-28 11:02:12', 'Voiture', 1, 28852858),
(17, 1, 1, 'y8uo247hgf', '2015-01-01 00:00:00', '2015-01-02 00:00:00', '2020-02-28 11:38:20', 'Voiture', 1, 28852858);

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `id` int(11) NOT NULL,
  `owner` int(11) DEFAULT NULL,
  `date_debut_location` datetime NOT NULL,
  `date_fin_location` datetime NOT NULL,
  `date` datetime NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `location` int(11) DEFAULT NULL,
  `barcode` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id`, `owner`, `date_debut_location`, `date_fin_location`, `date`, `type`, `location`, `barcode`) VALUES
(37, 1, '2015-01-01 00:00:00', '2015-01-01 00:00:00', '2020-02-24 23:03:30', 'Voiture', 4, '67dj4wevk9');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `id_guide` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomImage` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dateDebut` datetime NOT NULL,
  `nbre_participants` int(11) NOT NULL,
  `lieu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datefin` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `id_guide`, `id_user`, `nom`, `nomImage`, `dateDebut`, `nbre_participants`, `lieu`, `prix`, `type`, `datefin`) VALUES
(1, NULL, NULL, 'nan', NULL, '2020-03-02 00:00:00', -12, 'tunis', 130, 'type', '2020-03-04 00:00:00'),
(2, NULL, NULL, 'jalal', NULL, '2020-03-04 00:00:00', 134, 'tn', 45, 'n', '2020-03-04 00:00:00'),
(3, NULL, NULL, 'nnaaaaaa', NULL, '2020-02-25 00:00:00', -3, 'hh', 15, 'kk', '2020-03-26 00:00:00'),
(4, NULL, NULL, 'xxxxxxxxxxx', NULL, '2020-03-02 00:00:00', 12, 'tunis', 130, 'type', '2020-03-04 00:00:00'),
(5, NULL, NULL, 'aaaaaaaaaaaaaaa', NULL, '2020-03-04 00:00:00', 155, 'tn', 45, 'n', '2020-03-04 00:00:00'),
(6, NULL, NULL, 'lllllllllll', NULL, '2020-02-25 00:00:00', 1, 'hh', 15, 'kk', '2020-03-26 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

CREATE TABLE `fos_user` (
  `id` int(11) NOT NULL,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '(DC2Type:array)',
  `image_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `image_id`, `phone`) VALUES
(1, 'moetaz Brayek', 'moetaz brayek', 'moetaz.brayek@esprit.tn', 'moetaz.brayek@esprit.tn', 1, NULL, '$2y$13$vIINHICKaO23hYdkZ620NeVhQgT7gVBRWsBHz/1eKDwk3XWLchF8K', '2020-02-28 12:08:58', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', '18cd86f467cd10502af2aaa00f5e632c.jpeg', NULL),
(2, 'ala', 'ala', 'ala@ala.aal', 'ala@ala.aal', 1, NULL, '$2y$13$Pux9hewVF/RGnSgQ3dI7o.nPTE/JJKVUEY5iSdCIZjDlZf1j0onoC', '2020-02-19 12:28:46', NULL, NULL, 'a:0:{}', '18cd86f467cd10502af2aaa00f5e632c.jpeg', NULL),
(5, 'sadek', 'sadek', 'moetazbusiness@gmail.com', 'moetazbusiness@gmail.com', 1, NULL, '$2y$13$aFQ3.TsumY8WDDVtOizjUe3xvAJ04kSaTvq.pTP/KRxojGgukDLt.', '2020-02-17 22:10:53', NULL, NULL, 'a:0:{}', '18cd86f467cd10502af2aaa00f5e632c.jpeg', NULL),
(6, 'sarra', 'sarra', 'sellerolux@gmail.com', 'sellerolux@gmail.com', 1, NULL, '$2y$13$Zi8N31iOY7Lp47pXS.jjku0DPfcPzJVh8xzY3BV5zLftDTOxY4yN2', '2020-02-18 11:55:44', NULL, NULL, 'a:0:{}', '18cd86f467cd10502af2aaa00f5e632c.jpeg', NULL),
(7, 'ala2', 'ala2', 'aaaaaaaaaaaaaaaa@gmail.com', 'aaaaaaaaaaaaaaaa@gmail.com', 1, NULL, '$2y$13$wEncD6s/yMAK5g5Y3d0h1eHwI5b4SZ5QXMBsDor95U1YB8WCKFlJq', '2020-02-21 10:05:53', NULL, NULL, 'a:0:{}', '18cd86f467cd10502af2aaa00f5e632c.jpeg', NULL),
(11, 'Junior', 'junior', 'moetadzbusiness@gmail.com', 'moetadzbusiness@gmail.com', 1, NULL, '$2y$13$Ze1IODg/HtTBxDYVxhy7mem.PTQ0lqpBRYLtWcCN2yGZ8Abhzawa6', '2020-02-22 12:29:01', NULL, NULL, 'a:0:{}', '27a3591ec6fe16a5be8a6858ffb1bd02.gif', NULL),
(60, 'fadda', NULL, 'faadda@esprit.tn', NULL, NULL, NULL, '$2y$13$KxxiQRSdbt9sbY40FM6/2.UMb.b8y1M5vto7ogkv4fdCZUD7PE/by', NULL, NULL, NULL, NULL, NULL, 123),
(62, 'ramzo', NULL, 'ooo.esprit.tn', NULL, NULL, NULL, '$2y$13$t0yQqrkplOZVa5XJBa7R0OWzKqArf2ohaTjICy6bAEnNh.LSZagrC', NULL, NULL, NULL, NULL, NULL, 1321),
(63, 'oussama', NULL, 'oussama.bourguiga@esprit.tn', NULL, NULL, NULL, '$2y$13$6n5lLjZC30jQg9CTf4aPuOiwLFLyg7wvTYpbcnSj0yhaWRW1pb8hy', NULL, NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', NULL, 96921774),
(67, 'sam', NULL, 'sam@esprit.tn', NULL, NULL, NULL, '$2y$13$b4K/cr/zPQMwiTRzktkMmO/2aaQUSEWuEnSkafVMSbcQ2HvTtGbPe', NULL, NULL, NULL, NULL, NULL, 6546565),
(68, 'safa', NULL, 'safa@gmail.com', NULL, NULL, NULL, '$2y$13$VG8d/oMMQlzzpbZI1iP5s.Z/HIPZzPn/peViEBRpM3KQvaP.FDObS', NULL, NULL, NULL, NULL, NULL, 546546),
(69, 'wess', NULL, 'wess@gmail.com', NULL, NULL, NULL, '$2y$13$2AKbiBrmpkEt2vdNZjhCaeUrTkrriMAr9RoeAdLMh3urjrGs6ngCm', NULL, NULL, NULL, NULL, NULL, 6565),
(70, 'ddd', NULL, 'wesss@gmail.com', NULL, NULL, NULL, '$2y$13$MLSU.Cuv9/3ddYu.Pca3EujsMaZD2dEfAEwcsZrjFP16MyL0YdW6G', NULL, NULL, NULL, NULL, NULL, 55),
(71, 'hamza', NULL, 'hamza@gmail.com', NULL, NULL, NULL, '$2y$13$i6RxYywt/95i0tbju8hHheVI5khaEqg4f8AAHDF.3.jWMVy297gIy', NULL, NULL, NULL, 'a:0:{}', NULL, 879879),
(72, 'oussamaaaa', NULL, 'bourguigaoussama11@gmail.com', NULL, NULL, NULL, '$2y$13$0Trb58eDfrX8c2Uj//2LpOYYynCeuGXRpAaOnFwDYPHTWBhDeYHJK', NULL, NULL, NULL, 'a:0:{}', NULL, 45454),
(73, 'spyx', NULL, 'moe@ecxc.tn', NULL, NULL, NULL, '$2y$13$P1VLcAj2lRO1Aw2ZPZjxauKJ91Rw.qHyRpxQWMe88sSMyJc4.ImRm', NULL, NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', NULL, 58804719),
(74, 'moetaz', NULL, 'mo@ea.tn', NULL, NULL, NULL, '$2y$13$bW/pDEcOxdLY9bHDzhR84uzK1i19w0b.rIZagWmjYeln3imrI/xD2', NULL, NULL, NULL, 'a:0:{}', NULL, 8550506),
(75, 'moetaz1', NULL, 'moetaz1@moetaz1.tn', NULL, NULL, NULL, '$2y$13$HK2ZOIN88SUDNuQZEvSRPOsuStPLAlFvdHgHrTe3EeB9gCwP94Tvm', NULL, NULL, NULL, 'a:0:{}', NULL, 52630036);

-- --------------------------------------------------------

--
-- Structure de la table `guide`
--

CREATE TABLE `guide` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `guide`
--

INSERT INTO `guide` (`id`, `id_user`, `nom`, `prenom`, `tel`) VALUES
(1, 1, 'bb', 'bb', 55588);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `owner` int(11) DEFAULT NULL,
  `matricule` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `marque` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `puissance` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `daily_price` double NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `owner`, `matricule`, `marque`, `model`, `category`, `puissance`, `daily_price`, `type`, `image_id`) VALUES
(1, 1, '180 tn 152', 'bmw', 'fffddd', 'bmw', '20', 100, 'voiture', 'd2a0baa699920c689fc36540805a4b83.jpeg'),
(2, NULL, '180 tn 152', 'bmw', '2019', 'ahla', '20', 100, 'voiture', 'd2a0baa699920c689fc36540805a4b83.jpeg');

-- --------------------------------------------------------

--
-- Structure de la table `location1`
--

CREATE TABLE `location1` (
  `id` int(20) NOT NULL,
  `matricule` int(20) NOT NULL,
  `marque` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `puissance` varchar(20) NOT NULL,
  `dailyPrice` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message_asso_famille`
--

CREATE TABLE `message_asso_famille` (
  `id` int(11) NOT NULL,
  `id_message` int(11) DEFAULT NULL,
  `login_envoi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `login_recep` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `id_recep` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `message_asso_famille`
--

INSERT INTO `message_asso_famille` (`id`, `id_message`, `login_envoi`, `login_recep`, `message`, `date`, `role`, `id_recep`) VALUES
(135, 121, 'bb', 'hhh', 'hi !!!!', '2020-03-28 21:28:57', 'Association', NULL),
(221, 71, 'hamza', 'hallo', 'ahla oussama', '2020-04-09 23:46:32', NULL, NULL),
(222, 66, 'hallo', 'hamza', 'ahla hamza', '2020-04-09 23:46:37', NULL, NULL),
(250, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:13', NULL, NULL),
(249, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:12', NULL, NULL),
(248, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:12', NULL, NULL),
(247, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:12', NULL, NULL),
(245, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:05', NULL, NULL),
(246, 66, 'hallo', 'hamza', 'ahla', '2020-04-14 13:34:11', NULL, NULL),
(244, 66, 'hallo', 'hamza', 'alaa', '2020-04-11 18:08:45', NULL, NULL),
(243, 66, 'hallo', 'hamza', 'alaa', '2020-04-11 18:08:42', NULL, NULL),
(242, 66, 'hallo', 'hamza', '', '2020-04-10 17:04:31', NULL, NULL),
(241, 66, 'hallo', 'bb', '', '2020-04-10 17:04:25', NULL, NULL),
(240, 66, 'hallo', 'hamza', 'kesah', '2020-04-09 23:57:38', NULL, NULL),
(239, 66, 'hallo', 'hamza', 'sahhit', '2020-04-09 23:57:22', NULL, NULL),
(238, 66, 'hallo', 'hamza', '', '2020-04-09 23:55:55', NULL, NULL),
(237, 71, 'hamza', 'hallo', '', '2020-04-09 23:55:37', NULL, NULL),
(236, 71, 'hamza', 'hallo', '', '2020-04-09 23:55:36', NULL, NULL),
(235, 71, 'hamza', 'hallo', 'sahhit', '2020-04-09 23:55:31', NULL, NULL),
(234, 71, 'hamza', 'hallo', '', '2020-04-09 23:55:00', NULL, NULL),
(233, 66, 'hallo', 'hamza', 'khalil', '2020-04-09 23:54:31', NULL, NULL),
(232, 66, 'hallo', 'hamza', '', '2020-04-09 23:50:35', NULL, NULL),
(231, 66, 'hallo', 'hamza', '', '2020-04-09 23:50:29', NULL, NULL),
(230, 71, 'hamza', 'hallo', 'oh ya 3alm', '2020-04-09 23:50:20', NULL, NULL),
(229, 71, 'hamza', 'hallo', 'oh ya 3alm', '2020-04-09 23:50:15', NULL, NULL),
(228, 71, 'hamza', 'hallo', '', '2020-04-09 23:50:06', NULL, NULL),
(227, 66, 'hallo', 'hamza', 'ya3tek 3asba', '2020-04-09 23:49:25', NULL, NULL),
(226, 66, 'hallo', 'hallo', 'ya3tek 3asba', '2020-04-09 23:48:34', NULL, NULL),
(225, 66, 'hallo', 'hamza', 'wink cv ?? ', '2020-04-09 23:46:54', NULL, NULL),
(224, 66, 'hallo', 'hamza', 'wink cv ?? ', '2020-04-09 23:46:52', NULL, NULL),
(223, 66, 'hallo', 'hamza', 'ahla hamza', '2020-04-09 23:46:39', NULL, NULL),
(220, 66, 'hallo', 'hamza', 'ahla hamza', '2020-04-09 23:45:40', NULL, NULL),
(219, 66, 'hallo', '', 'ahlaaaa', '2020-04-09 23:33:15', NULL, NULL),
(218, 66, 'hallo', '', 'ahlaaaa', '2020-04-09 23:33:05', NULL, NULL),
(216, 66, 'hallo', '', 'ahla', '2020-04-09 23:25:53', NULL, NULL),
(215, 71, 'hamza', '', 'ahla', '2020-04-09 23:09:07', NULL, NULL),
(214, 71, 'hamza', '', 'ahla', '2020-04-09 23:09:03', NULL, NULL),
(213, 66, 'hallo', '', 'ahla', '2020-04-09 23:07:51', NULL, NULL),
(212, 66, 'hallo', '', 'afla', '2020-04-09 22:49:15', NULL, NULL),
(217, 66, 'hallo', '', 'ahlaaaa', '2020-04-09 23:33:04', NULL, NULL),
(251, 73, 'spyx', 'hallo', 'hi', '2020-05-31 20:36:05', NULL, NULL),
(252, 73, 'spyx', 'hamza', 'hi', '2020-05-31 20:36:09', NULL, NULL),
(253, 73, 'spyx', 'bb', 'hi', '2020-05-31 20:36:12', NULL, NULL),
(254, 74, 'moetaz', 'spyx', 'hello From mMoetaz', '2020-06-01 08:18:26', NULL, NULL),
(255, 75, 'moetaz1', 'moetaz', 'Hello from moetaz1', '2020-06-01 08:19:07', NULL, NULL),
(256, 74, 'moetaz', 'moetaz1', 'Hello from moetaz :D welcome how are you ?', '2020-06-01 08:19:33', NULL, NULL),
(257, 74, 'moetaz', 'moetaz1', 'Hello from moetaz :D welcome how are you ?', '2020-06-01 08:19:33', NULL, NULL),
(258, 75, 'moetaz1', 'moetaz', 'haha thank you bro i\'m well', '2020-06-01 08:20:01', NULL, NULL),
(259, 74, 'moetaz', 'moetaz1', 'test pi', '2020-06-01 13:31:44', NULL, NULL),
(260, 75, 'moetaz1', 'moetaz', 'thank u', '2020-06-01 13:32:10', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `notifcation`
--

CREATE TABLE `notifcation` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `route` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `route_parameters` longtext COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '(DC2Type:array)',
  `notification_date` datetime NOT NULL,
  `seen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `notifcation`
--

INSERT INTO `notifcation` (`id`, `title`, `description`, `icon`, `route`, `route_parameters`, `notification_date`, `seen`) VALUES
(42, 'New comment', 'New comment has been added \"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mi dolor, malesuada id metus a, mattis eleifend elit. Nullam pharetra consequat ex in dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus lacinia dui tellus. Donec condimentum vel diam eget accumsan. Fusce sit amet nunc fermentum, mattis lacus eu, euismod ipsum. Nam tincidunt leo sed lorem ultricies molestie. In in turpis id risus lacinia finibus eget eget eros. Mauris lobortis, tortor eu ornare conva mauris tortor blandit orci, nec eleifend velit dolor sit amet nunc.Suspendisse vel ipsum tempor, volutpat arcuat, faucibus mi. In efficitur lorem mattis diam finibus finibus.</p>\r\n\r\n<blockquote>&nbsp;</blockquote>\"', NULL, 'comment_show', 'a:1:{s:2:\"id\";i:26;}', '2020-02-28 01:54:38', 0),
(43, 'Comment updated', '\"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mi dolor, malesuada id metus a, mattis eleifend elit. Nullam pharetra consequat ex in dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Viva\" has been updated', NULL, 'comment_show', 'a:1:{s:2:\"id\";i:26;}', '2020-02-28 01:55:07', 0),
(44, 'New comment', 'New comment has been added \"<p><img alt=\"surprise\" src=\"http://localhost/Pidev-web/web/bundles/fosckeditor/plugins/smiley/images/omg_smile.png\" style=\"height:23px; width:23px\" title=\"surprise\" />&nbsp;Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a convallis nisl, at aliquam dolor. Morbi in iaculis nunc nulla velit imperdiet sollicitudin.</p>\"', NULL, 'comment_show', 'a:1:{s:2:\"id\";i:27;}', '2020-02-28 07:29:59', 0),
(45, 'Comment updated', '\"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mi dolor, malesuada id metus a, mattis eleifend elit. Nullam pharetra consequat ex in dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Viva\" has been updated', NULL, 'comment_show', 'a:1:{s:2:\"id\";i:26;}', '2020-02-28 10:34:49', 0),
(46, 'Comment updated', '\"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mi dolor, malesuada id metus a, mattis eleifend elit. Nullam pharetra consequat ex in dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Viva\" has been updated', NULL, 'comment_show', 'a:1:{s:2:\"id\";i:26;}', '2020-02-28 10:35:15', 0);

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zip_code` int(11) NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `price` double NOT NULL,
  `produit_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `state`, `country`, `zip_code`, `etat`, `phone`, `price`, `produit_id`) VALUES
(10, 1, 'Antalya', 'United Kingdom', 7600, 'Confirmed', 58804717, 10, NULL),
(11, 1, 'gafsa', '1', 2151, 'Declined', 58804719, 5, NULL),
(12, 1, '', 'United Kingdom', 0, 'Confirmed', 0, 200, NULL),
(13, 1, '', 'United Kingdom', 0, 'Declined', 0, 0, NULL),
(14, 1, '', 'United Kingdom', 0, 'notConfirmed', 0, 100, NULL),
(15, 1, '', 'United Kingdom', 0, 'notConfirmed', 0, 100, NULL),
(16, 1, '', 'United Kingdom', 0, 'notConfirmed', 0, 100, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `produit_id` int(11) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `date_p` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id`, `user_id`, `produit_id`, `quantite`, `prix`, `date_p`) VALUES
(35, 1, 14, 15, 1500, '2020-02-28 02:50:05');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_evenement` int(11) DEFAULT NULL,
  `validation` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id`, `id_user`, `id_evenement`, `validation`) VALUES
(1, 1, 1, 'validé'),
(3, 1, 10, 'validé'),
(4, 0, 1, 'validé'),
(5, 0, 3, 'en cours'),
(6, 0, 2, 'en cours'),
(7, 0, 4, 'en cours'),
(8, 0, 2, 'en cours'),
(9, 0, 2, 'en cours'),
(10, 0, 2, 'en cours'),
(11, 0, 2, 'en cours'),
(12, 0, 3, 'en cours'),
(13, 0, 4, 'en cours'),
(14, 0, 1, 'en cours'),
(15, 71, 1, 'en cours'),
(16, 71, 2, 'en cours'),
(17, 71, 4, 'en cours'),
(22, 71, 2, 'en cours'),
(24, 71, 1, 'en cours'),
(28, 71, 1, 'en cours'),
(29, 71, 1, 'en cours'),
(30, 71, 1, 'en cours'),
(31, 71, 1, 'en cours'),
(32, 71, 1, 'en cours'),
(33, 71, 1, 'en cours'),
(34, 71, 1, 'en cours'),
(35, 71, 1, 'en cours'),
(36, 71, 1, 'en cours'),
(40, 71, 1, 'en cours'),
(41, 71, 1, 'en cours'),
(45, 71, 2, 'en cours'),
(46, 71, 2, 'en cours'),
(47, 71, 2, 'en cours'),
(48, 71, 2, 'en cours'),
(49, 71, 2, 'en cours'),
(50, 71, 2, 'en cours'),
(51, 71, 2, 'en cours'),
(52, 71, 2, 'en cours'),
(55, 71, 2, 'en cours'),
(57, 71, 1, 'en cours'),
(58, 71, 5, 'en cours'),
(59, 71, 1, 'en cours');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `owner` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `region` int(11) DEFAULT NULL,
  `nom` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(10000) COLLATE utf8_unicode_ci NOT NULL,
  `stars` double DEFAULT NULL,
  `prix` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `image_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `owner`, `category`, `region`, `nom`, `description`, `stars`, `prix`, `quantity`, `image_id`, `date`) VALUES
(1, NULL, NULL, NULL, 'd', 'dd', NULL, 11, 11, 'J56NUZK6YL.jpg', '2020-03-31'),
(42, NULL, NULL, NULL, 'taz', 'zaeda', NULL, 450, 50, 'J56NUZK6YL.jpg', '2020-06-08'),
(433, NULL, NULL, NULL, 'taz', 'zaeda', NULL, 450, 50, 'VK8VMJROAK.jpg', '2020-06-08'),
(436, NULL, NULL, NULL, 'hh', 'hh', NULL, 12, 12, 'PROKCMVWC7.jpg', '2020-06-03'),
(437, NULL, NULL, NULL, 'azer', 'zer', NULL, 50, 50, 'PEPIKSFWHS.jpg', '2020-06-04'),
(438, NULL, NULL, NULL, 'azer', 'zer', NULL, 50, 50, 'RV4XNNZCG3.jpg', '2020-06-04'),
(439, NULL, NULL, NULL, 'azer', 'zer', NULL, 50, 50, 'YOWAVJSPJ6.jpg', '2020-06-04');

-- --------------------------------------------------------

--
-- Structure de la table `produit_review`
--

CREATE TABLE `produit_review` (
  `produit_id` int(11) NOT NULL,
  `reviews_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `produit_review`
--

INSERT INTO `produit_review` (`produit_id`, `reviews_id`) VALUES
(4, 7),
(7, 8),
(12, 9);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `region` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `replymessage`
--

CREATE TABLE `replymessage` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `msg` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `replymessage`
--

INSERT INTO `replymessage` (`id`, `name`, `email`, `subject`, `message`, `msg`) VALUES
(30, 'Hello', 'moetazbusiness@gmail.com', 'bad', 'bad', 93),
(31, 'Hunt', 'fez@zefze', 'WHY YOU ARE SAD', 'how i can improve my service', 97);

-- --------------------------------------------------------

--
-- Structure de la table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `produit_id` int(11) DEFAULT NULL,
  `stars` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reviews`
--

INSERT INTO `reviews` (`id`, `user_id`, `produit_id`, `stars`, `title`, `description`, `date`) VALUES
(6, 1, 4, '4', 'é\"&&é\"é&\"', 'zaezaeazeaze', '2020-02-19 16:08:52'),
(7, 7, 4, '5', 'BGood', 'Thank You For This Product  Amazing', '2020-02-19 16:58:54'),
(8, 7, 7, '4', 'aaaaa', 'dsfsdfdsfdsfdsfdsfdsf', '2020-02-19 21:18:47'),
(9, 1, 12, '1', 'zaeaze', '3fat', '2020-02-26 23:03:47');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_C015514320641732` (`Idauthor`),
  ADD KEY `IDX_C0155143497DD634` (`categorie`);

--
-- Index pour la table `blog2`
--
ALTER TABLE `blog2`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_F5C0BB76497DD634` (`categorie`),
  ADD KEY `IDX_F5C0BB7620641732` (`Idauthor`);

--
-- Index pour la table `blog_like`
--
ALTER TABLE `blog_like`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_4CB3CC238D93D649` (`user`),
  ADD KEY `IDX_4CB3CC23C0155143` (`blog`),
  ADD KEY `IDX_4CB3CC239474526C` (`comment`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie_blog`
--
ALTER TABLE `categorie_blog`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `catgory_car`
--
ALTER TABLE `catgory_car`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_9474526C8D93D649` (`user`),
  ADD KEY `IDX_9474526CC0155143` (`blog`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_4C62E6388D93D649` (`user`);

--
-- Index pour la table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_10F94A0F5E9E89CB` (`location`),
  ADD KEY `IDX_10F94A0FCF60E67C` (`owner`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_60349993CF60E67C` (`owner`),
  ADD KEY `IDX_603499935E9E89CB` (`location`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B26681E241B8605` (`id_guide`),
  ADD KEY `IDX_B26681E6B3CA4B` (`id_user`);

--
-- Index pour la table `fos_user`
--
ALTER TABLE `fos_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  ADD UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`);

--
-- Index pour la table `guide`
--
ALTER TABLE `guide`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_CA9EC7356B3CA4B` (`id_user`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_A7E8EB9DCF60E67C` (`owner`);

--
-- Index pour la table `message_asso_famille`
--
ALTER TABLE `message_asso_famille`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `notifcation`
--
ALTER TABLE `notifcation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_E52FFDEEA76ED395` (`user_id`),
  ADD KEY `IDX_E52FFDEEF347EFB` (`produit_id`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_24CC0DF2A76ED395` (`user_id`),
  ADD KEY `IDX_24CC0DF2F347EFB` (`produit_id`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_AB55E24F6B3CA4B` (`id_user`),
  ADD KEY `IDX_AB55E24F8B13D439` (`id_evenement`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_29A5EC27CF60E67C` (`owner`),
  ADD KEY `IDX_29A5EC2764C19C1` (`category`),
  ADD KEY `IDX_29A5EC27F62F176` (`region`);

--
-- Index pour la table `produit_review`
--
ALTER TABLE `produit_review`
  ADD PRIMARY KEY (`produit_id`,`reviews_id`),
  ADD KEY `IDX_8E114AFCF347EFB` (`produit_id`),
  ADD KEY `IDX_8E114AFC8092D97F` (`reviews_id`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `replymessage`
--
ALTER TABLE `replymessage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_46F771EC688A5FAF` (`msg`);

--
-- Index pour la table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_6970EB0FA76ED395` (`user_id`),
  ADD KEY `IDX_6970EB0FF347EFB` (`produit_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT pour la table `blog2`
--
ALTER TABLE `blog2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `blog_like`
--
ALTER TABLE `blog_like`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `categorie_blog`
--
ALTER TABLE `categorie_blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `catgory_car`
--
ALTER TABLE `catgory_car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT pour la table `contract`
--
ALTER TABLE `contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `fos_user`
--
ALTER TABLE `fos_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT pour la table `guide`
--
ALTER TABLE `guide`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `message_asso_famille`
--
ALTER TABLE `message_asso_famille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=261;

--
-- AUTO_INCREMENT pour la table `notifcation`
--
ALTER TABLE `notifcation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=440;

--
-- AUTO_INCREMENT pour la table `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `replymessage`
--
ALTER TABLE `replymessage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `FK_C015514320641732` FOREIGN KEY (`Idauthor`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_C0155143497DD634` FOREIGN KEY (`categorie`) REFERENCES `categories` (`id`);

--
-- Contraintes pour la table `blog2`
--
ALTER TABLE `blog2`
  ADD CONSTRAINT `FK_F5C0BB7620641732` FOREIGN KEY (`Idauthor`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_F5C0BB76497DD634` FOREIGN KEY (`categorie`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
