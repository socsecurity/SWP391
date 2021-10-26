USE [master]
GO
/****** Object:  Database [Restaurant]    Script Date: 10/26/2021 8:26:32 PM ******/
CREATE DATABASE [Restaurant]
 CONTAINMENT = NONE
 
GO
ALTER DATABASE [Restaurant] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Restaurant].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Restaurant] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Restaurant] SET ARITHABORT OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Restaurant] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Restaurant] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Restaurant] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Restaurant] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Restaurant] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Restaurant] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Restaurant] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Restaurant] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Restaurant] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Restaurant] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Restaurant] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Restaurant] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Restaurant] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Restaurant] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Restaurant] SET RECOVERY FULL 
GO
ALTER DATABASE [Restaurant] SET  MULTI_USER 
GO
ALTER DATABASE [Restaurant] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Restaurant] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Restaurant] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Restaurant] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Restaurant] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Restaurant] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Restaurant', N'ON'
GO
ALTER DATABASE [Restaurant] SET QUERY_STORE = OFF
GO
USE [Restaurant]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[Category_id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_detail]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_detail](
	[order_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[quantity] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Product_id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[Status] [nchar](20) NOT NULL,
	[Price] [int] NOT NULL,
	[Category_id] [int] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_Id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[role_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Order]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Order](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[date] [datetime] NOT NULL,
	[status] [nvarchar](20) NOT NULL,
	[table_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Table]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Table](
	[table_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](30) NOT NULL,
	[status] [nvarchar](20) NOT NULL,
	[hour] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[table_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 10/26/2021 8:26:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[User_id] [int] NOT NULL,
	[password] [nchar](10) NOT NULL,
	[full_name] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NULL,
	[phone_number] [nchar](10) NULL,
	[role_id] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Category] ([Category_id], [name]) VALUES (1, N'Appetizer')
INSERT [dbo].[Category] ([Category_id], [name]) VALUES (2, N'Entree')
INSERT [dbo].[Category] ([Category_id], [name]) VALUES (3, N'Dessert')
INSERT [dbo].[Category] ([Category_id], [name]) VALUES (4, N'Fast food')
INSERT [dbo].[Category] ([Category_id], [name]) VALUES (5, N'Drinks')
GO
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (2, 1, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (2, 3, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (2, 15, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (2, 10, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (3, 4, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (3, 5, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (3, 20, 3)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (4, 14, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (4, 10, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (5, 21, 7)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (7, 13, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (7, 1, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (8, 16, 3)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (8, 4, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (8, 7, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (9, 12, 5)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (9, 18, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (10, 5, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (10, 6, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (11, 6, 3)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (11, 1, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (12, 5, 7)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (12, 3, 1)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (10, 25, 3)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (13, 26, 4)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (13, 27, 2)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (14, 27, 6)
INSERT [dbo].[Order_detail] ([order_id], [product_id], [quantity]) VALUES (15, 30, 8)
GO
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (1, N'Spaghetti', N'In Stock            ', 30, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (2, N'Mini Sandwiches', N'In Stock            ', 18, 1)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (3, N'Hoagie Dip', N'In Stock            ', 20, 1)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (4, N'Asparagus Puff Pastry Bundles', N'In Stock            ', 23, 1)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (5, N'Salad', N'In Stock            ', 16, 1)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (6, N'Spring roll', N'In Stock            ', 15, 1)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (7, N'Vegan chicken and mushroom pie', N'In Stock            ', 30, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (8, N'Vegan Roast Beef with vegetables', N'In Stock            ', 35, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (9, N'Vegan Lasagna', N'In Stock            ', 32, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (10, N'marrakesh vegetable curry', N'In Stock            ', 29, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (11, N'Hotpot', N'In Stock            ', 40, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (12, N'Mixed grill', N'In Stock            ', 37, 2)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (13, N'Ice-cream', N'In Stock            ', 8, 3)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (14, N'Mixed fruits', N'In Stock            ', 12, 3)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (15, N'Apple pie', N'In Stock            ', 20, 3)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (16, N'Cheesecake', N'In Stock            ', 20, 3)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (17, N'chocolate molten lava cake', N'Out Of Stock        ', 25, 3)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (18, N'Hamburger', N'In Stock            ', 25, 4)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (19, N'Pizza', N'In Stock            ', 35, 4)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (20, N'Chips', N'In Stock            ', 18, 4)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (21, N'Toast', N'In Stock            ', 20, 4)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (22, N'Hotdog', N'In Stock            ', 15, 4)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (23, N'Milk', N'In Stock            ', 8, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (24, N'Coffee', N'In Stock            ', 9, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (25, N'MilkTea', N'In Stock            ', 7, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (26, N'Lava Flow Hawaiian Tropical', N'Out Of Stock        ', 10, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (27, N'Colla', N'In Stock            ', 5, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (28, N'Seasonal Sparkle', N'In Stock            ', 7, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (29, N'Rose Tea', N'In Stock            ', 5, 5)
INSERT [dbo].[Product] ([Product_id], [name], [Status], [Price], [Category_id]) VALUES (30, N'Virgin Mojito', N'Out Of Stock        ', 11, 5)
GO
INSERT [dbo].[Role] ([role_Id], [name]) VALUES (1, N'manager ')
INSERT [dbo].[Role] ([role_Id], [name]) VALUES (2, N'waiter ')
INSERT [dbo].[Role] ([role_Id], [name]) VALUES (3, N'chef')
INSERT [dbo].[Role] ([role_Id], [name]) VALUES (4, N'receptionist')
INSERT [dbo].[Role] ([role_Id], [name]) VALUES (5, N'cashier')
GO
SET IDENTITY_INSERT [dbo].[tbl_Order] ON 

INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (2, CAST(N'2021-10-01T12:30:00.000' AS DateTime), N'PROCESSING', 1, 2)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (3, CAST(N'2021-10-01T10:21:00.000' AS DateTime), N'CANCELED', 2, 4)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (4, CAST(N'2021-10-01T12:09:00.000' AS DateTime), N'PROCESSING', 3, 1)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (5, CAST(N'2021-10-01T13:34:00.000' AS DateTime), N'COMPLETE', 6, 2)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (7, CAST(N'2021-10-01T10:01:00.000' AS DateTime), N'COMPLETE', 1, 6)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (8, CAST(N'2021-10-01T11:12:00.000' AS DateTime), N'CANCELED', 3, 3)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (9, CAST(N'2021-10-02T07:10:00.000' AS DateTime), N'COMPLETE', 4, 5)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (10, CAST(N'2021-10-02T07:40:00.000' AS DateTime), N'PROCESSING', 1, 3)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (11, CAST(N'2021-10-02T08:34:00.000' AS DateTime), N'PROCESSING', 4, 5)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (12, CAST(N'2021-10-02T12:10:00.000' AS DateTime), N'CANCELED', 6, 10)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (13, CAST(N'2021-12-02T10:10:20.000' AS DateTime), N'PROCESSING', 10, 5)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (14, CAST(N'2021-12-05T09:10:25.000' AS DateTime), N'CANCELED', 5, 7)
INSERT [dbo].[tbl_Order] ([order_id], [date], [status], [table_id], [user_id]) VALUES (15, CAST(N'2021-12-07T08:12:21.000' AS DateTime), N'COMPLETE', 6, 8)
SET IDENTITY_INSERT [dbo].[tbl_Order] OFF
GO
SET IDENTITY_INSERT [dbo].[tbl_Table] ON 

INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (1, N'Table 1 - 4 people', N'AVAILABLE', NULL)
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (2, N'Table 2 - 2 people', N'NOT AVAILABLE', CAST(N'2021-10-01T17:00:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (3, N'Table 3 - 10 people', N'NOT AVAILABLE', CAST(N'2021-10-01T16:00:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (4, N'Table 4 - 5 people', N'AVAILABLE', NULL)
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (5, N'Table 5 - 8 people', N'NOT AVAILABLE', CAST(N'2021-10-01T17:20:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (6, N'Table 6 - 6 people', N'AVAILABLE', NULL)
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (7, N'Table 7 - 4 people', N'AVAILABLE', NULL)
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (8, N'Table 8 - 2 people', N'NOT AVAILABLE', CAST(N'2021-10-01T16:43:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (9, N'Table 9 - 10 people', N'NOT AVAILABLE', CAST(N'2021-10-01T17:12:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (10, N'Table 10 - 5 people', N'AVAILABLE', NULL)
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (11, N'Table 11 - 8 people', N'NOT AVAILABLE', CAST(N'2021-10-01T17:03:00.000' AS DateTime))
INSERT [dbo].[tbl_Table] ([table_id], [name], [status], [hour]) VALUES (12, N'Table 12 - 6 people', N'AVAILABLE', NULL)
SET IDENTITY_INSERT [dbo].[tbl_Table] OFF
GO
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (1, N'12345     ', N'Nguyễn Thị Diễm Hà', N'43 Đống Đa', N'0901256789', 1)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (2, N'54321     ', N'Lê Hồng Bảo Ngân', N'20 Ngũ Hành Sơn', N'0905778278', 1)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (3, N'199       ', N'Ali Baldul', N'23 Aura', N'0901786689', 2)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (4, N'6650      ', N'Mina Anna', N'7 Tokyo', N'0906872637', 4)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (5, N'7565      ', N'Phạm Mạnh Tuấn', N'30 Phạm Ngũ Lão', N'0901786735', 3)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (6, N'8877      ', N'Nguyễn Thị Mỹ Hồng', N'28 Bạch Mã', N'0901897654', 3)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (7, N'5636      ', N'Phan Hoàng Minh', N'32 Pastel', N'0905667878', 2)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (8, N'7886      ', N'Lê Ánh Mỹ', N'54 Hoàng Diệu', N'0901883882', 5)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (9, N'7676      ', N'Trần Tiến Công', N'87 Ngô Quyền', N'0905782789', 3)
INSERT [dbo].[User] ([User_id], [password], [full_name], [Address], [phone_number], [role_id]) VALUES (10, N'7878      ', N'Nguyễn Ánh My', N'59 Lê Duẩn', N'0905123467  ', 4)
GO
ALTER TABLE [dbo].[Order_detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_detail_Product] FOREIGN KEY([product_id])
REFERENCES [dbo].[Product] ([Product_id])
GO
ALTER TABLE [dbo].[Order_detail] CHECK CONSTRAINT [FK_Order_detail_Product]
GO
ALTER TABLE [dbo].[Order_detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_detail_tbl_Order] FOREIGN KEY([order_id])
REFERENCES [dbo].[tbl_Order] ([order_id])
GO
ALTER TABLE [dbo].[Order_detail] CHECK CONSTRAINT [FK_Order_detail_tbl_Order]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([Category_id])
REFERENCES [dbo].[Category] ([Category_id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[tbl_Order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Order_tbl_Table] FOREIGN KEY([table_id])
REFERENCES [dbo].[tbl_Table] ([table_id])
GO
ALTER TABLE [dbo].[tbl_Order] CHECK CONSTRAINT [FK_tbl_Order_tbl_Table]
GO
ALTER TABLE [dbo].[tbl_Order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Order_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([User_id])
GO
ALTER TABLE [dbo].[tbl_Order] CHECK CONSTRAINT [FK_tbl_Order_User]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([role_Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
USE [master]
GO
ALTER DATABASE [Restaurant] SET  READ_WRITE 
GO
