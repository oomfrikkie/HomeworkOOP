S    private GamingPc testPc;
    private Motherboard testmobo;
    private Game testgame;
    private Ssd testSsd;
    private Ssd testssd2;
    private Gpu testGpu;

    @BeforeEach
    void setup()
    {
        testmobo = new Motherboard(12);
        testPc = new GamingPc( testmobo );
        testgame = new Game("Test Game", 500, 200);
        testGpu = new Gpu(4000, 2000);
        testSsd = new Ssd(1000);
        testssd2 = new Ssd(1000);

        testmobo.addGraphicsCard(testGpu);
        testmobo.addSsd(testSsd);

    }
    @org.junit.jupiter.api.Test
    void installGame_gameOf500mb_shouldPass()
    {
        testPc.installGame( testgame );


        assertTrue(testSsd.getInstalledGames().contains(testgame));
        assertEquals(500, testSsd.getAvailableCapactity());
    }

    @org.junit.jupiter.api.Test
    void installGame_with1FullSsd_shouldPass()
    {
        testmobo.addSsd( testssd2 );
        testSsd.setAvailableCapactity( 0 );

        testPc.installGame( testgame );

        assertFalse(testSsd.getInstalledGames().contains( testgame ));
        assertTrue(testssd2.getInstalledGames().contains( testgame ));
    }

    @org.junit.jupiter.api.Test
    void installGame_withSsdFull_shouldPass()
    {
        testSsd.setAvailableCapactity( 0 );

        try
        {
            testPc.installGame( testgame );
        }
        catch(RuntimeException e)
        {
            assertEquals("Not enough space for " + testgame.getTitle() , e.getMessage());
        }


        assertFalse(testSsd.getInstalledGames().contains( testgame ));
    }

    @org.junit.jupiter.api.Test
    void hasEnoughSpace()
    {

    }

}