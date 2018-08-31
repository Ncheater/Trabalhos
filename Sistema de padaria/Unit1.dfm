object log: Tlog
  Left = 399
  Top = 238
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'Login'
  ClientHeight = 114
  ClientWidth = 410
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 11
    Top = 28
    Width = 50
    Height = 16
    Caption = 'Usu'#225'rio:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label2: TLabel
    Left = 216
    Top = 28
    Width = 42
    Height = 16
    Caption = 'Senha:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object usu: TEdit
    Left = 64
    Top = 24
    Width = 121
    Height = 24
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
  end
  object senha: TEdit
    Left = 264
    Top = 24
    Width = 121
    Height = 24
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    PasswordChar = '*'
    TabOrder = 1
  end
  object acessar: TButton
    Left = 167
    Top = 59
    Width = 75
    Height = 25
    Caption = 'Acessar'
    Default = True
    TabOrder = 2
    OnClick = acessarClick
  end
  object esenha: TButton
    Left = 144
    Top = 88
    Width = 121
    Height = 17
    Caption = 'Esqueci minha senha'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -9
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 3
    OnClick = esenhaClick
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=MSDASQL.1;Persist Security Info=False;User ID=postgres;' +
      'Data Source=PostgreSQL30'
    LoginPrompt = False
    Left = 16
    Top = 67
  end
  object ADOQuery1: TADOQuery
    Active = True
    Connection = ADOConnection1
    CursorType = ctStatic
    Parameters = <>
    SQL.Strings = (
      'select * from padaria.tb_usuario')
    Left = 48
    Top = 67
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
      FieldName = 'tel_usu'
    end
    object ADOQuery1tipo_usu: TStringField
      FieldName = 'tipo_usu'
      FixedChar = True
      Size = 4
    end
  end
end
