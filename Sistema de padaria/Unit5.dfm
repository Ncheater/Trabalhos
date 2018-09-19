object produ: Tprodu
  Left = 53
  Top = 149
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'Cadastro de produtos'
  ClientHeight = 223
  ClientWidth = 599
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnClose = FormClose
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Label2: TLabel
    Left = 16
    Top = 48
    Width = 28
    Height = 13
    Caption = 'Nome'
  end
  object TLabel
    Left = 16
    Top = 80
    Width = 28
    Height = 13
    Caption = 'Pre'#231'o'
  end
  object btnInserir: TButton
    Left = 56
    Top = 113
    Width = 89
    Height = 23
    Caption = 'Inserir'
    TabOrder = 0
    OnClick = btnInserirClick
  end
  object btnCancelar: TButton
    Left = 136
    Top = 144
    Width = 57
    Height = 25
    Caption = 'Cancelar'
    TabOrder = 1
    OnClick = btnCancelarClick
  end
  object btnDeletar: TButton
    Left = 8
    Top = 144
    Width = 57
    Height = 25
    Caption = 'Deletar'
    TabOrder = 2
    OnClick = btnDeletarClick
  end
  object DBGrid1: TDBGrid
    Left = 200
    Top = 16
    Width = 385
    Height = 193
    DataSource = DataSource1
    ReadOnly = True
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
        FieldName = 'id_prod'
        Title.Caption = 'ID'
        Width = 50
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'nome_prod'
        Title.Caption = 'Nome'
        Width = 179
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'preco_prod'
        Title.Caption = 'Pre'#231'o'
        Width = 108
        Visible = True
      end>
  end
  object edtNome: TDBEdit
    Left = 64
    Top = 48
    Width = 121
    Height = 21
    DataField = 'nome_prod'
    DataSource = DataSource1
    TabOrder = 4
  end
  object edtPreco: TDBEdit
    Left = 64
    Top = 80
    Width = 121
    Height = 21
    DataField = 'preco_prod'
    DataSource = DataSource1
    TabOrder = 5
  end
  object btnEditar: TButton
    Left = 72
    Top = 144
    Width = 57
    Height = 25
    Caption = 'Editar'
    TabOrder = 6
    OnClick = btnEditarClick
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=MSDASQL.1;Persist Security Info=False;User ID=postgres;' +
      'Data Source=PostgreSQL30'
    LoginPrompt = False
    Left = 8
    Top = 8
  end
  object ADOQuery1: TADOQuery
    Active = True
    Connection = ADOConnection1
    CursorType = ctStatic
    Parameters = <>
    SQL.Strings = (
      'Select * from padaria.tb_produto')
    Left = 40
    Top = 8
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
    Left = 72
    Top = 8
  end
end
