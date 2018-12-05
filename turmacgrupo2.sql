-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 05, 2014 at 11:03 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `turmacgrupo2`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `orgao_emissor` varchar(5) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `nome`, `endereco`, `data_nascimento`, `telefone`, `cnpj`, `cpf`, `tipo`, `rg`, `orgao_emissor`, `uf`) VALUES
(1, 'nada', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'marina', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `id_Compra` int(11) NOT NULL AUTO_INCREMENT,
  `data_compra` date DEFAULT NULL,
  `valor_compra` double DEFAULT NULL,
  `Fornecedor_id_Fornecedor` int(11) NOT NULL,
  `Funcionario_id_Funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_Compra`),
  KEY `fk_Compra_Fornecedor1` (`Fornecedor_id_Fornecedor`),
  KEY `fk_Compra_Funcionario1` (`Funcionario_id_Funcionario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `compra`
--

INSERT INTO `compra` (`id_Compra`, `data_compra`, `valor_compra`, `Fornecedor_id_Fornecedor`, `Funcionario_id_Funcionario`) VALUES
(1, NULL, 21, 1, 1),
(2, NULL, 157.5, 1, 1),
(3, NULL, 525, 1, 1),
(4, NULL, 210, 1, 1),
(5, NULL, 315, 1, 1),
(6, NULL, 315, 1, 1),
(9, NULL, NULL, 1, 1),
(10, NULL, NULL, 1, 1),
(11, NULL, NULL, 1, 1),
(12, NULL, 929.6999999999999, 1, 1),
(13, NULL, 15000, 1, 1),
(14, NULL, 2000, 1, 1),
(15, NULL, 2500, 1, 1),
(16, NULL, 2000, 1, 1),
(17, NULL, 2000, 1, 1),
(18, NULL, NULL, 1, 1),
(19, NULL, NULL, 1, 1),
(20, NULL, 210, 1, 1),
(21, '2014-03-05', 3000, 1, 1),
(22, NULL, 315, 1, 1),
(23, NULL, 1239.6, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `det_compra`
--

CREATE TABLE IF NOT EXISTS `det_compra` (
  `Compra_id_Compra` int(11) NOT NULL AUTO_INCREMENT,
  `Produto_id_Produto` int(11) NOT NULL,
  `valor_total` double DEFAULT NULL,
  `qtd_venda` int(11) DEFAULT NULL,
  `valor_unitario` double DEFAULT NULL,
  PRIMARY KEY (`Compra_id_Compra`,`Produto_id_Produto`),
  KEY `fk_Det_Compra_Compra1` (`Compra_id_Compra`),
  KEY `fk_Det_Compra_Produto1` (`Produto_id_Produto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `det_compra`
--

INSERT INTO `det_compra` (`Compra_id_Compra`, `Produto_id_Produto`, `valor_total`, `qtd_venda`, `valor_unitario`) VALUES
(1, 2, 21, 2, 10.5),
(2, 2, 157.5, 15, 10.5),
(3, 2, 525, 50, 10.5),
(4, 2, 210, 20, 10.5),
(5, 2, 315, 30, 10.5),
(6, 2, 315, 30, 10.5),
(12, 3, 929.6999999999999, 30, 30.99),
(13, 7, 15000, 300, 50),
(14, 7, 2000, 40, 50),
(15, 7, 2500, 50, 50),
(16, 7, 2000, 40, 50),
(17, 8, 2000, 50, 40),
(20, 2, 210, 20, 10.5),
(21, 7, 1000, 20, 50),
(21, 8, 3000, 50, 40),
(22, 2, 315, 30, 10.5),
(23, 3, 1239.6, 40, 30.99);

-- --------------------------------------------------------

--
-- Table structure for table `det_venda`
--

CREATE TABLE IF NOT EXISTS `det_venda` (
  `Produto_id_Produto` int(11) NOT NULL,
  `Venda_id_Venda` int(11) NOT NULL AUTO_INCREMENT,
  `qtde_venda` int(11) DEFAULT NULL,
  `valor_unitario` double DEFAULT NULL,
  `valor_total` double DEFAULT NULL,
  PRIMARY KEY (`Produto_id_Produto`,`Venda_id_Venda`),
  KEY `fk_Det_Venda_Produto1` (`Produto_id_Produto`),
  KEY `fk_Det_Venda_Venda1` (`Venda_id_Venda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `det_venda`
--

INSERT INTO `det_venda` (`Produto_id_Produto`, `Venda_id_Venda`, `qtde_venda`, `valor_unitario`, `valor_total`) VALUES
(2, 1, 5, 10.5, 52.5),
(2, 4, 5, 10.5, 52.5),
(2, 5, 10, 10.5, 105),
(3, 2, 10, 30.99, 309.9),
(7, 3, 40, 50, 2000),
(7, 6, 4, 50, 200),
(8, 7, 10, 40, 400);

-- --------------------------------------------------------

--
-- Table structure for table `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
  `id_Estoque` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `qtde` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `tipo` varchar(1) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Estoque`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `estoque`
--

INSERT INTO `estoque` (`id_Estoque`, `descricao`, `qtde`, `data`, `tipo`, `valor`, `saldo`) VALUES
(1, 'sandalia', 30, NULL, 'E', 10.5, 160),
(7, 'chinelo', 40, NULL, 'E', 30.99, 80),
(8, 'sapato', 4, NULL, 'S', 50, 346),
(9, 'tenis', 10, NULL, 'S', 40, 90);

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id_Fornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_forn` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `cep_forn` varchar(12) DEFAULT NULL,
  `endereco_forn` varchar(45) DEFAULT NULL,
  `cnpj_forn` varchar(20) DEFAULT NULL,
  `rg_forn` varchar(15) DEFAULT NULL,
  `orgao_emissor` varchar(5) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_Fornecedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`id_Fornecedor`, `nome_forn`, `email`, `telefone`, `celular`, `fax`, `cep_forn`, `endereco_forn`, `cnpj_forn`, `rg_forn`, `orgao_emissor`, `uf`) VALUES
(1, 'elmo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_Funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `admissao` date DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  `acesso` tinyint(1) DEFAULT NULL,
  `foto` blob,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_Funcionario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`id_Funcionario`, `nome`, `cargo`, `admissao`, `login`, `senha`, `acesso`, `foto`, `telefone`) VALUES
(1, 'gerson', 'Administrador', NULL, 'gerson', '123', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nivel_acesso`
--

CREATE TABLE IF NOT EXISTS `nivel_acesso` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_func` int(11) DEFAULT NULL,
  `acesso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `nivel_acesso`
--

INSERT INTO `nivel_acesso` (`codigo`, `cod_func`, `acesso`) VALUES
(1, 1, 'CLIENTE'),
(2, 1, 'COMPRA'),
(3, 1, 'PRODUTO'),
(4, 1, 'FUNCIONARIO'),
(5, 1, 'FORNECEDOR'),
(8, 1, 'VENDA'),
(9, 1, 'Controle de acesso');

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id_Produto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `preco_produto` double DEFAULT NULL,
  PRIMARY KEY (`id_Produto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`id_Produto`, `descricao`, `preco_produto`) VALUES
(2, 'sandalia', 10.5),
(3, 'chinelo', 30.99),
(7, 'sapato', 50),
(8, 'tenis', 40);

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `id_Venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` date DEFAULT NULL,
  `valor_venda` double DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  `num_parcelas` double DEFAULT NULL,
  `Cliente_id_Cliente` int(11) NOT NULL,
  `Funcionario_id_Funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_Venda`),
  KEY `fk_Venda_Cliente1` (`Cliente_id_Cliente`),
  KEY `fk_Venda_Funcionario1` (`Funcionario_id_Funcionario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `venda`
--

INSERT INTO `venda` (`id_Venda`, `data_venda`, `valor_venda`, `desconto`, `num_parcelas`, `Cliente_id_Cliente`, `Funcionario_id_Funcionario`) VALUES
(1, NULL, 52.5, 0, NULL, 1, 1),
(2, NULL, 309.9, 0, NULL, 1, 1),
(3, NULL, 2000, 0, NULL, 1, 1),
(4, NULL, 52.5, 0, NULL, 1, 1),
(5, NULL, 105, 0, NULL, 1, 1),
(6, NULL, 200, 0, NULL, 1, 1),
(7, NULL, 400, 0, NULL, 1, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_Compra_Fornecedor1` FOREIGN KEY (`Fornecedor_id_Fornecedor`) REFERENCES `fornecedor` (`id_Fornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Compra_Funcionario1` FOREIGN KEY (`Funcionario_id_Funcionario`) REFERENCES `funcionario` (`id_Funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `det_compra`
--
ALTER TABLE `det_compra`
  ADD CONSTRAINT `fk_Det_Compra_Compra1` FOREIGN KEY (`Compra_id_Compra`) REFERENCES `compra` (`id_Compra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Det_Compra_Produto1` FOREIGN KEY (`Produto_id_Produto`) REFERENCES `produto` (`id_Produto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `det_venda`
--
ALTER TABLE `det_venda`
  ADD CONSTRAINT `fk_Det_Venda_Produto1` FOREIGN KEY (`Produto_id_Produto`) REFERENCES `produto` (`id_Produto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Det_Venda_Venda1` FOREIGN KEY (`Venda_id_Venda`) REFERENCES `venda` (`id_Venda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_Venda_Cliente1` FOREIGN KEY (`Cliente_id_Cliente`) REFERENCES `cliente` (`id_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Venda_Funcionario1` FOREIGN KEY (`Funcionario_id_Funcionario`) REFERENCES `funcionario` (`id_Funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
