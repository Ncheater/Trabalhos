program prjPadaria;

uses
  Forms,
  uCadastroProduto in 'uCadastroProduto.pas' {Form1},
  uConsultaProduto in 'uConsultaProduto.pas' {Form2};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TForm1, Form1);
  Application.CreateForm(TForm2, Form2);
  Application.Run;
end.
