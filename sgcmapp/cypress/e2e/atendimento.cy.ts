describe('Testa agendamento', () => {
    beforeEach(() => {
        cy.intercept('GET', '/atendimento/', {
            statusCode: 200,
            fixture: 'atendimentos.json'
        });
        cy.visit('/');
        cy.get('nav a').contains('Agenda').click();
    });
    it('Deve ser capaz de agendar um novo atendimento', () => {
        cy.intercept('GET', '/convenio/', {
            statusCode: 200,
            fixture: 'convenios.json'
        });
        cy.intercept('GET', '/profissional/', {
            statusCode: 200,
            fixture: 'profissionais.json'
        });
        cy.intercept('GET', '/paciente/', {
            statusCode: 200,
            fixture: 'pacientes.json'
        });
        cy.intercept('GET', '/atendimento/', {
            statusCode: 200,
            fixture: 'atendimentos.json'
        });

        cy.get('#add').click();
        cy.get('select[name="profissional"]').select('Davi Jesus Mendes');
        cy.get('input[name="data"]').type('2023-12-02');
        cy.get('select[name="hora"]').select('14:00:00');
        cy.get('select[name="convenio"]').select('Unimed')
        cy.get('select[name="paciente"]').select('Helen Dutra Vilar');

        cy.fixture('atendimentos.json').then((atendimentos) => {
            cy.fixture('atendimento-insert.json').then((novoAtendimento) => {
                atendimentos.push(novoAtendimento);
                cy.intercept('GET', '/atendimento/', {
                    statusCode: 200,
                    body: atendimentos
                });
            });
        });

        cy.get('input[type="submit"]').click();
        //cy.contains('Operação realizada com sucesso.')
        cy.get('table tbody tr:last').within(() => {
            cy.get('td').eq(0).contains('02/12/2023');
            cy.get('td.fit').eq(1).contains('14:00');
            cy.get('td').eq(2).contains('Helen Dutra Vilar');
        });
    });//fecha o it (teste)
});