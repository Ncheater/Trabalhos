program Project1;

uses
  Forms,
  Unit1 in 'Unit1.pas' {log},
  Unit2 in 'Unit2.pas' {nsenha},
  Unit3 in 'Unit3.pas' {mmenu},
  Unit4 in 'Unit4.pas' {cad};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(Tlog, log);
  Application.CreateForm(Tnsenha, nsenha);
  Application.CreateForm(Tmmenu, mmenu);
  Application.CreateForm(Tcad, cad);
  Application.Run;
end.
