object f_consulta: Tf_consulta
  Left = 306
  Top = 97
  Width = 573
  Height = 267
  Caption = 'Consultar Produtos'
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
  object DBGrid1: TDBGrid
    Left = 208
    Top = 32
    Width = 337
    Height = 185
    DataSource = DataSource1
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'MS Sans Serif'
    TitleFont.Style = []
    Columns = <
      item
        Expanded = False
        FieldName = 'id_prod'
        Title.Caption = 'ID'
        Width = 30
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'nome_prod'
        Title.Caption = 'Nome'
        Width = 162
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'preco_prod'
        Title.Caption = 'Pre'#231'o'
        Width = 103
        Visible = True
      end>
  end
  object GroupBox1: TGroupBox
    Left = 16
    Top = 32
    Width = 185
    Height = 153
    Caption = 'Consultar'
    TabOrder = 1
    object pesquisa: TButton
      Left = 55
      Top = 112
      Width = 75
      Height = 25
      Caption = 'Pesquisa'
      TabOrder = 0
      OnClick = pesquisaClick
    end
    object id: TEdit
      Left = 16
      Top = 40
      Width = 33
      Height = 21
      TabOrder = 1
    end
    object nome: TEdit
      Left = 16
      Top = 80
      Width = 121
      Height = 21
      TabOrder = 2
    end
    object rbt_id: TRadioButton
      Left = 16
      Top = 24
      Width = 49
      Height = 17
      Caption = 'ID'
      TabOrder = 3
      OnClick = rbt_idClick
    end
    object rbt_nome: TRadioButton
      Left = 16
      Top = 64
      Width = 113
      Height = 17
      Caption = 'Nome'
      TabOrder = 4
    end
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=MSDASQL.1;Persist Security Info=False;Data Source=Postg' +
      'reSQL30'
    LoginPrompt = False
    Left = 112
  end
  object ADOQuery1: TADOQuery
    Active = True
    Connection = ADOConnection1
    CursorType = ctStatic
    Parameters = <>
    SQL.Strings = (
      'SELECT * FROM padaria.tb_produto')
    Left = 144
    object ADOQuery1id_prod: TAutoIncField
      FieldName = 'id_prod'
      ReadOnly = True
    end
    object ADOQuery1preco_prod: TBCDField
      Alignment = taLeftJustify
      FieldName = 'preco_prod'
      DisplayFormat = 'R$ #0.00'
      Precision = 32
      Size = 2
    end
    object ADOQuery1nome_prod: TStringField
      FieldName = 'nome_prod'
      FixedChar = True
      Size = 32
    end
  end
  object DataSource1: TDataSource
    DataSet = ADOQuery1
    Left = 176
  end
end
