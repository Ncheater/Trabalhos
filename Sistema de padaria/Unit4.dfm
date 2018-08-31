object cad: Tcad
  Left = 460
  Top = 252
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'Manuten'#231#227'o de usu'#225'rios'
  ClientHeight = 303
  ClientWidth = 780
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 16
    Top = 16
    Width = 241
    Height = 169
    Caption = 'Dados'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 33
      Width = 40
      Height = 16
      Caption = 'Nome:'
    end
    object Label2: TLabel
      Left = 10
      Top = 120
      Width = 36
      Height = 16
      Caption = 'Login:'
      FocusControl = DBEdit2
    end
    object Label3: TLabel
      Left = 8
      Top = 76
      Width = 57
      Height = 16
      Caption = 'Telefone:'
      FocusControl = DBEdit3
    end
    object DBEdit2: TDBEdit
      Left = 56
      Top = 116
      Width = 163
      Height = 24
      DataField = 'login_usu'
      DataSource = DataSource1
      TabOrder = 0
    end
    object DBEdit3: TDBEdit
      Left = 72
      Top = 72
      Width = 147
      Height = 24
      DataField = 'tel_usu'
      DataSource = DataSource1
      TabOrder = 1
    end
    object DBEdit1: TDBEdit
      Left = 56
      Top = 30
      Width = 161
      Height = 24
      DataField = 'nome_usu'
      DataSource = DataSource1
      TabOrder = 2
    end
  end
  object admin: TRadioGroup
    Left = 16
    Top = 192
    Width = 241
    Height = 65
    Caption = 'Tipo de usu'#225'rio'
    Columns = 2
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    Items.Strings = (
      'Administrador'
      'Vendedor')
    ParentFont = False
    TabOrder = 1
  end
  object Button1: TButton
    Left = 43
    Top = 264
    Width = 75
    Height = 25
    Caption = 'Cadastrar'
    TabOrder = 2
    OnClick = Button1Click
  end
  object DBGrid1: TDBGrid
    Left = 272
    Top = 16
    Width = 497
    Height = 273
    DataSource = DataSource1
    TabOrder = 3
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'MS Sans Serif'
    TitleFont.Style = []
    OnCellClick = DBGrid1CellClick
    Columns = <
      item
        Expanded = False
        FieldName = 'login_usu'
        Title.Caption = 'Login'
        Width = 115
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'nome_usu'
        Title.Caption = 'Nome'
        Width = 158
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'tel_usu'
        Title.Caption = 'Telefone'
        Width = 113
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'tipo_usu'
        Title.Caption = 'Administrador'
        Width = 68
        Visible = True
      end>
  end
  object Button2: TButton
    Left = 152
    Top = 264
    Width = 75
    Height = 25
    Caption = 'Remover'
    TabOrder = 4
    OnClick = Button2Click
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=MSDASQL.1;Persist Security Info=False;User ID=postgres;' +
      'Data Source=PostgreSQL30'
    LoginPrompt = False
    Left = 176
  end
  object ADOQuery1: TADOQuery
    Active = True
    Connection = ADOConnection1
    CursorType = ctStatic
    Parameters = <>
    SQL.Strings = (
      'select * from padaria.tb_usuario')
    Left = 208
    object ADOQuery1id_usu: TAutoIncField
      FieldName = 'id_usu'
      ReadOnly = True
    end
    object ADOQuery1login_usu: TStringField
      FieldName = 'login_usu'
      FixedChar = True
      Size = 32
    end
    object ADOQuery1senha_usu: TStringField
      FieldName = 'senha_usu'
      FixedChar = True
      Size = 32
    end
    object ADOQuery1nome_usu: TStringField
      FieldName = 'nome_usu'
      FixedChar = True
      Size = 64
    end
    object ADOQuery1tel_usu: TLargeintField
      Alignment = taLeftJustify
      FieldName = 'tel_usu'
      DisplayFormat = '(00) #0000-0000'
    end
    object ADOQuery1tipo_usu: TStringField
      FieldName = 'tipo_usu'
      FixedChar = True
      Size = 4
    end
  end
  object DataSource1: TDataSource
    DataSet = ADOQuery1
    Left = 240
  end
end
